package com.maxwit.stack;

import org.junit.Assert;
import org.junit.Test;

public class MySequentialStackTest {

    @Test
    public void v10Test() {
        MySequentialStack<Integer> stack = new MySequentialStack<>();
        final Integer N = 6;
        for (int i = 0; i < N; i++) {
            stack.push(i + 1);
        }

        Assert.assertEquals(stack.peek(), N);

        for (Integer i = N; i > 0; i--) {
            Assert.assertEquals(stack.pop(), i);
        }

        Assert.assertTrue(stack.isEmpty());

    }
}
