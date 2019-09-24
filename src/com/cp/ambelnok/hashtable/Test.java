package com.cp.ambelnok.hashtable;

import com.cp.ambelnok.hashtable.Map.OpenAddressHashMap;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        OpenAddressHashMap map = new OpenAddressHashMap(2_000_000, 1);
        ArrayList<Integer> list = new ArrayList<>(7_000_000);
        ArrayList<Long> longlist = new ArrayList<>(7_000_000);
        for (int i = 0; i < 7_000_000; i++) {
            list.add(i);
            longlist.add((long) i);
        }
        Collections.shuffle(list);
        Collections.shuffle(longlist);
        HashMap<Integer, Long> map1 = new HashMap<>();
        long before = System.currentTimeMillis();
        for (int i = 0; i < 7_000_000; i++) {
            map.put(list.get(i), longlist.get(i));
        }
        long after = System.currentTimeMillis();
        System.out.println(after - before);

    }
}
