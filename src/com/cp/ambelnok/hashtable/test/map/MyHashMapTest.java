package com.cp.ambelnok.hashtable.test.map;

import com.cp.ambelnok.hashtable.exceptions.EmptyMapException;
import com.cp.ambelnok.hashtable.exceptions.NoSuchKeyException;
import com.cp.ambelnok.hashtable.map.MyHashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {
    private int size = 1000_000;
    private MyHashMap hashMap = new MyHashMap(size, 1);

    void init() {
        for (int i = 0; i < size+2; i++) {
            hashMap.put(i, i * 200);
        }
    }

    @Test
    void isEmptyNoEntries() {
        assertTrue(hashMap.isEmpty());
    }

    @Test
    void isEmptyWithEntries() {
        init();
        assertFalse(hashMap.isEmpty());
    }

    @Test
    void entryNumberInitial() {
        assertEquals(hashMap.getUsedNodeAmount(), 0);
    }

    @Test
    void entryNumberFilled() {
        init();
        assertEquals(hashMap.getUsedNodeAmount(), size+2);
    }

    @Test
    void clearInitial() {
        init();
        hashMap.clear();
        assertTrue(hashMap.isEmpty());
    }

    @Test
    void clearEmpty() {
        hashMap.clear();
        assertTrue(hashMap.isEmpty());
    }

    @Test
    void containsKeyEmpty() {
        assertFalse(hashMap.containsKey(5));
    }

    @Test
    void containsKeyPresent() {
        init();
        assertTrue(hashMap.containsKey(5));
    }

    @Test
    void containsValueEmpty() {
        assertFalse(hashMap.containsValue(2000));
    }

    @Test
    void containsValuePresent() {
        init();
        assertTrue(hashMap.containsValue(2000));
    }


    @Test
    void putPositive() {
        hashMap.put(1, 100);
        hashMap.put(1, 120);
        hashMap.put(2, 120);
        hashMap.put(size + 1, 120);
        assertEquals(hashMap.getUsedNodeAmount(), 3);
    }

    @Test
    void putNegative() {
        hashMap.put(-1, 100);
        hashMap.put(-1, 100);
        hashMap.put(-2, 100);
        hashMap.put(-size - 1, 100);
        assertEquals(hashMap.getUsedNodeAmount(), 3);
    }

    @Test
    void getValue() throws NoSuchKeyException, EmptyMapException {
        init();
        assertEquals(hashMap.get(1000_001), 200_000_200);
    }
}
