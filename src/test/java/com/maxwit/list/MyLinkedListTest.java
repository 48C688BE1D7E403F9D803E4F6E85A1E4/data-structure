package com.maxwit.list;

import org.junit.Assert;
import org.junit.Test;


public class MyLinkedListTest {

    @Test
    public void v01Test() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        final Integer N = 6;
        for (int i = 0; i < N; i++) {
            list.insert(i + 1);
        }

        list.traversal(e -> System.out.print(e + " "));

        Integer n = N;
        for(Integer x : list) {
            Assert.assertEquals(x, n--);
        }

        Assert.assertTrue(n == 0);
    }
}
