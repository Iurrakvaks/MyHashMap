package com.cp.ambelnok.hashtable.Hasher;

public class NodeHasher implements Hasher {

    private final int size;

    public NodeHasher(int size) {
        this.size = size;
    }

    @Override
    public int getHash(int key) {
        return Hasher.mask(key) % size;
    }

}
