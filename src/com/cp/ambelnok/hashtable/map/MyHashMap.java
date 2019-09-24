package com.cp.ambelnok.hashtable.map;

import com.cp.ambelnok.hashtable.exceptions.EmptyMapException;
import com.cp.ambelnok.hashtable.exceptions.NoSuchKeyException;
import com.cp.ambelnok.hashtable.probe.LinearProbe;
import com.cp.ambelnok.hashtable.indexer.NodeIndexer;

public class MyHashMap implements OpenAddressMap {

    private int size;
    private double loadFactor = 0.7d;
    private int usedNodeAmount;
    private LinearProbe probe;
    private NodeIndexer nodeIndexer;
    private Node[] nodes;


    public MyHashMap(int size, int step) {
        this.size = size;
        this.probe = new LinearProbe(step);
        this.nodes = new Node[this.size];
        this.nodeIndexer = new NodeIndexer(this.size);
    }

    public double getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(double loadFactor) {
        this.loadFactor = loadFactor;
    }

    @Override
    public void put(int key, long value) {
        if (checkResize()) {
            resize();
        }
        int index = findIndex(key);
        if (nodes[index] != null) {
            nodes[index].setValue(value);
        } else {
            nodes[index] = new Node(key, value);
            usedNodeAmount++;
        }
    }

    private void put(Node node) {

    }


    private int findIndex(int key) {
        int index = nodeIndexer.getIndex(key);
        while (checkCollision(index, key)) {
            index = nodeIndexer.getIndex(probe.getNext(index));
        }
        return nodeIndexer.getIndex(index);
    }

    private boolean checkCollision(int index, int key) {
        if (nodes[index] != null) {
            return nodes[index].getKey() != key;
        } else {
            return false;
        }
    }

    private boolean checkResize() {
        return usedNodeAmount >= loadFactor * size;
    }


    @Override
    public long get(int key) throws NoSuchKeyException, EmptyMapException {
        if (usedNodeAmount != 0) {
            Node node = nodes[findIndex(key)];
            if (node != null) {
                return node.getValue();
            }
            throw new NoSuchKeyException();
        }
        throw new EmptyMapException();
    }

    @Override
    public boolean isEmpty() {
        return usedNodeAmount == 0;
    }

    @Override
    public void resize() {
        Node[] oldNodesArray = nodes;
        this.size = size * 2 + 1;
        this.nodeIndexer = new NodeIndexer(size);
        nodes = new Node[size];

        for (Node node : oldNodesArray) {
            if (node != null) {
                int index = findIndex(node.getKey());
                nodes[index] = node;
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    public int getUsedNodeAmount() {
        return usedNodeAmount;
    }

    @Override
    public void clear() {
        usedNodeAmount = 0;
        nodes = new Node[size];
    }

    @Override
    public boolean containsKey(int key) {
        if (usedNodeAmount != 0) {
            int index = findIndex(key);
            return nodes[index] != null;
        }
        return false;
    }

    @Override
    public boolean containsValue(long value) {
        if (usedNodeAmount != 0) {
            for (Node node : nodes) {
                if (node != null) {
                    if (node.getValue() == value) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private class Node {

        int key;
        long value;

        Node(int key, long value) {
            this.key = key;
            this.value = value;
        }

        long getValue() {
            return value;
        }

        void setValue(long value) {
            this.value = value;
        }

        int getKey() {
            return key;
        }


    }
}
