package com.cp.ambelnok.hashtable.Map;

public interface OpenAddressMap {
    void put(int key, long value);

    long get(int key);

    int size();

    void clear();

    default void resize() {
    }

    boolean isEmpty();

    boolean containsValue(long value);

    boolean containsKey(int key);

}
