package com.cp.ambelnok.hashtable.test.indexer;

import com.cp.ambelnok.hashtable.indexer.NodeIndexer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeIndexerTest {
    private int size = 1000;
    private NodeIndexer nodeIndexer = new NodeIndexer(size);


    @Test
    void getIndexWithNegativeKey(){
        for (int i = 0; i > -100_000; i--) {
            assertTrue(nodeIndexer.getIndex(i) < size && nodeIndexer.getIndex(i) >= 0);
        }
    }

    @Test
    void getIndexWithPositiveKey(){
        for (int i = 0; i < 100_000; i++) {
            assertTrue(nodeIndexer.getIndex(i) < size);
        }
    }

}
