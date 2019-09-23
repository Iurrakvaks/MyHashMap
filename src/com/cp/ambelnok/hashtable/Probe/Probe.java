package com.cp.ambelnok.hashtable.Probe;

public interface Probe {

    int step = 1;

    int getNext(int collisionIndex);

}
