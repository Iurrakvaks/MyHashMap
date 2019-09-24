package com.cp.ambelnok.hashtable;

import com.cp.ambelnok.hashtable.exceptions.EmptyMapException;
import com.cp.ambelnok.hashtable.exceptions.NoSuchKeyException;
import com.cp.ambelnok.hashtable.map.MyHashMap;

public class Test {
    public static void main(String[] args) throws NoSuchKeyException, EmptyMapException {
        MyHashMap map = new MyHashMap(5, 4);
        for (int i = 0; i < 12; i++) {
            map.put(i,i);
        }
        System.out.println(map.get(4));

    }
}
