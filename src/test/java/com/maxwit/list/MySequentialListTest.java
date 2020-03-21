package com.maxwit.list;

import org.junit.Test;

public class MySequentialListTest {

    @Test
    public void v01Test() {
        MySequentialList<Integer> sl = new MySequentialList<>();

        final int N = 6;
        for (int i = 1; i < N; i++) {
            sl.insert(i * 11);
        }
        sl.traversal();

        sl.insert(0, 6);
        sl.traversal();

        sl.insert(3, 7);
        sl.traversal();

        sl.insert(7, 8);
        sl.traversal();

        sl.remove();
        sl.traversal();

        sl.remove(0);
        sl.traversal();


    }
}
