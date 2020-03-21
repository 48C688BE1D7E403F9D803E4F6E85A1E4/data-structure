package com.maxwit.listv10;

import org.junit.Assert;
import org.junit.Test;

public class MySequentialListTest {

    @Test
    public void v10Test() {
        MySequentialList<Integer> sl = new MySequentialList<>();

        final Integer N = 6;
        for (int i = 0; i < N; i++) {
            sl.insert(i,i + 1);
        }

        Assert.assertTrue(sl.set(0, N));

        Integer x = sl.get(0);
        Assert.assertEquals(x, N);

        Assert.assertEquals(sl.contains(N), 2);

        Assert.assertEquals(sl.remove(0), N);

        int size = sl.length();
        Assert.assertEquals(sl.removeAll(), size);
        Assert.assertEquals(sl.length(), 0);
    }
}
