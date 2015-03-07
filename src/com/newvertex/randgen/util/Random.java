package com.newvertex.randgen.util;

public class Random {

    private int start;
    private int end;

    public Random() {
        this(0, 1000);
    }

    public Random(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int randomClass() {
        return new java.util.Random().nextInt((end - start) + start + 1);
    }
}
