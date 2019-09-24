package com.cp.ambelnok.hashtable.Probe;

public class LinearProbe implements Probe {

    private int step;

    public LinearProbe(int step) {
        this.step = step;
    }

    @Override
    public int getNext(int collisionIndex) {
        return collisionIndex + step;
    }
}
