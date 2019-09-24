package com.cp.ambelnok.hashtable;

import com.cp.ambelnok.hashtable.map.MyHashMap;
import com.cp.ambelnok.hashtable.exceptions.EmptyMapException;
import com.cp.ambelnok.hashtable.exceptions.NoSuchKeyException;

public class Test {
    public static void main(String[] args) throws NoSuchKeyException, EmptyMapException {
        MyHashMap map = new MyHashMap(5, 1);
        map.put(1,15);
        map.put(11,15);
        System.out.println(map.get(21));

    }
}
