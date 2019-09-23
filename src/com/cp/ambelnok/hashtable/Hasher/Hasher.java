package com.cp.ambelnok.hashtable.Hasher;

public interface Hasher {


    static int mask(int value){
        return value & 0xFFFFFFF;
    }

    int getHash(int maskedValue);
}
