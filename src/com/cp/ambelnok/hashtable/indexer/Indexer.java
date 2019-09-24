package com.cp.ambelnok.hashtable.indexer;

public interface Indexer {

    static int mask(int value) {
        return value & 0xFFFFFFF;
    }

    int getIndex(int maskedValue);
}
