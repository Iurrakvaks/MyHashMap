package com.cp.ambelnok.hashtable.map;

import com.cp.ambelnok.hashtable.exceptions.EmptyMapException;
import com.cp.ambelnok.hashtable.exceptions.NoSuchKeyException;

public interface OpenAddressMap {
    void put(int key, long value);

    long get(int key) throws NoSuchKeyException, EmptyMapException;

    int size();

    void clear();

    default void resize() {
    }

    boolean isEmpty();

    boolean containsValue(long value);

    boolean containsKey(int key);

}
