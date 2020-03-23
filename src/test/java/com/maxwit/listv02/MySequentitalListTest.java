package com.maxwit.listv02;

import org.junit.Assert;
import org.junit.Test;

public class MySequentitalListTest {

    @Test
    public void v02Test() {
        MySequentialList<Integer> sl = new MySequentialList<>();

        final int N = 6;
        for (int i = 0; i < N; i++) {
            sl.insert(i + 1);
        }

        sl.traversal(e -> System.out.print(e + " "));
        System.out.println();

        Integer n = 1;
        for (Integer x : sl) {
            Assert.assertEquals(x, n++);
        }

        Assert.assertTrue(n == N + 1);

        List<String> list = new MySequentialList<>();
        list.insert("AA");
        list.insert("BB");
        list.traversal(e -> System.out.print(e + " "));
    }
}
