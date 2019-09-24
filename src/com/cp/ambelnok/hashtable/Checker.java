package com.cp.ambelnok.hashtable;

import com.cp.ambelnok.hashtable.exceptions.EmptyMapException;
import com.cp.ambelnok.hashtable.exceptions.NoSuchKeyException;
import com.cp.ambelnok.hashtable.map.MyHashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Checker {
    private int selectionSize = 10_000_000;
    private List<Integer> keys = new ArrayList<>(selectionSize);
    private List<Long> values = new ArrayList<>(selectionSize);
    private MyHashMap hashMap;

    public void setHashMap(MyHashMap hashMap, int selectionSize) {
        this.hashMap = hashMap;
        this.selectionSize = selectionSize;
    }

    private void generateInput() {
        for (int i = 0; i < selectionSize; i++) {
            keys.add(i);
            values.add((long) i);
        }
        Collections.shuffle(keys);
        Collections.shuffle(values);
    }

    private void testPut() {
        long before = System.currentTimeMillis();
        for (int i = 0; i < selectionSize; i++) {
            hashMap.put(keys.get(i), values.get(i));
        }
        long after = System.currentTimeMillis();
        System.out.println("Put time: " + (after - before));
    }

    private void testGet() throws NoSuchKeyException, EmptyMapException {
        long before = System.currentTimeMillis();
        for (int i = 0; i < selectionSize; i++) {
            hashMap.get(keys.get(i));
        }
        long after = System.currentTimeMillis();
        System.out.println("Get time: " + (after - before));
    }

    public void mainTest() throws NoSuchKeyException, EmptyMapException {
        generateInput();
        testPut();
        testGet();
    }

    public static void main(String[] args) throws NoSuchKeyException, EmptyMapException {
        MyHashMap hashMap = new MyHashMap(5_000_000, 1);
        MyHashMap hashMap2 = new MyHashMap(5_000_000, 5);
        Checker checker = new Checker();
        checker.generateInput();
        checker.setHashMap(hashMap, 5_000_000);
        checker.testPut();
        checker.testGet();
        checker.setHashMap(hashMap2, 5_000_000);
        checker.testPut();
        checker.testGet();
    }
}
