package com.maxwit.listv10;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void v10Test() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        final Integer N = 6;
        for (int i = 0; i < N; i++) {
            list.insert(i, i + 1);
        }

        Integer n = 1;
        for (Integer x : list) {
            Assert.assertEquals(x, n++);
        }

        Assert.assertTrue(n == N + 1);

        Assert.assertTrue(!list.isEmpty());

        Integer value = 66;
        int index = 0;
        Assert.assertTrue(list.set(index, value));
        Assert.assertEquals(list.get(index), value);

        Assert.assertEquals(list.remove(list.length() - 1), N);
        Assert.assertEquals(list.length(), N - 1);

        list.set(index + 1, value);
        Assert.assertEquals(list.contains(value), 2);

        int len = list.length();
        Assert.assertEquals(list.removeAll(), len);
        Assert.assertTrue(list.isEmpty());
    }
}