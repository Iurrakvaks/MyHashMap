package com.cp.ambelnok.hashtable.Map;

import com.cp.ambelnok.hashtable.Probe.LinearProbe;
import com.cp.ambelnok.hashtable.Node.Node;
import com.cp.ambelnok.hashtable.Hasher.NodeHasher;

public class OpenAddressHashMap implements OpenAddressMap {

    private int size;
    private double loadFactor = 0.75d;
    private int usedNodeAmount;
    private LinearProbe probe;
    private NodeHasher nodeHasher;
    private Node[] nodes;


    public OpenAddressHashMap(int size, int step){
        this.size = size;
        this.probe = new LinearProbe(step);
        this.nodes = new Node[this.size];
        this.nodeHasher = new NodeHasher(this.size);
    }

    public double getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(double loadFactor) {
        this.loadFactor = loadFactor;
    }

    @Override
    public void put(int key, long value) {
        if (checkResize()){ resize(); }
        int index = findIndex(key);
        if (nodes[index] != null){
            nodes[index].setValue(value);
        }
        else{
            nodes[index] = new Node(key, value);
            usedNodeAmount++;
        }
    }

    private void put(Node node){
        int index = findIndex(node.getKey());
        nodes[index] = node;
    }


    private int findIndex(int key){
        int index = nodeHasher.getHash(key);
        while (checkCollision(index, key)){
            if(index < this.size){
                index = probe.getNext(index);
            }
            else{
                index = probe.getNext(0);
            }
        }
        return nodeHasher.getHash(index);
    }

    private boolean checkCollision(int index, int key){
        if(index >= this.size){
            return true;
        }
        else if(nodes[index] != null){
          return nodes[index].getKey() != key;
        }
        else{
            return false;
        }
    }

    private boolean checkResize(){
        return usedNodeAmount >= loadFactor * size;
    }


    @Override
    public long get(int key) {
        if (usedNodeAmount != 0) {
            return nodes[findIndex(key)].getValue();
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean isEmpty() {
        return usedNodeAmount == 0;
    }

    @Override
    public void resize() {
        Node[] oldNodesArray = nodes;
        this.size = size*2+1;
        this.nodeHasher = new NodeHasher(size);
        nodes = new Node[size];

        for (Node node : oldNodesArray){
            if (node != null){
                put(node);
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        usedNodeAmount = 0;
        nodes = new Node[size];
    }

    @Override
    public boolean containsKey(int key) {
        if (nodes != null & usedNodeAmount != 0) {
            for (Node node : nodes) {
                if (node != null) {
                    return node.getKey() == key;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(long value) {
        if (nodes != null & usedNodeAmount !=0){
            for (Node node : nodes) {
                if (node != null) {
                    return node.getValue() == value;
                }
            }
        }
        return false;
    }

    public void remove(int key){
        nodes[findIndex(key)].setAvailable(true);


    }
}
