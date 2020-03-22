package com.maxwit.queue;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedQueueTest {

    @Test
    public void linkedQueueTest() {
        MyLinkedQueue<Integer> q = new MyLinkedQueue<>();

        final Integer N = 6;
        for (int i = 0; i < N; i++)
            q.enQueue(i + 1);

        Assert.assertEquals(q.front(), N);

        for (Integer i = N; i > 0; i--) {
            Assert.assertEquals(q.deQueue(), i);
        }

        Assert.assertTrue(q.isEmpty());

    }
}
