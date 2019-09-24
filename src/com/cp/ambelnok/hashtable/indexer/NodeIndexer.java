package com.cp.ambelnok.hashtable.indexer;

public class NodeIndexer implements Indexer {

    private final int size;

    public NodeIndexer(int size) {
        this.size = size;
    }

    @Override
    public int getIndex(int key) {
        return Indexer.mask(key) % (size);
    }

}
