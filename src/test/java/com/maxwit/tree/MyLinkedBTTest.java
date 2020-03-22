package com.maxwit.tree;

import org.junit.Assert;
import org.junit.Test;


public class MyLinkedBTTest {

    interface Fun<T> {
        public void check(T[] data, int i, T cdata);
    }

    @Test
    public void traversal() {
        MyLinkedBT<Integer> bt = new MyLinkedBT<>(11);
        bt.insert(11, 0, 22);
        bt.insert(11, 1, 33);
        bt.insert(22, 0, 44);

        bt.preTraversal(e -> System.out.print(e + " "));
        System.out.println();

        bt.inTraversal(e -> System.out.print(e + " "));
        System.out.println();

        bt.lastTraversal(e -> System.out.print(e + " "));
        System.out.println();
    }
}
