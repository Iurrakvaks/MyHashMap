package com.cp.ambelnok.hashtable.Node;

public class Node {

    private int key;
    private long value;
    private boolean available;

    public Node (int key, long value){
        this.key = key;
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean value) {
        available = value;
    }
}