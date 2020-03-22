package com.maxwit.queue;

import com.maxwit.listv10.MyLinkedList;

public class MyLinkedQueue<T> extends MyLinkedList<T> {

    MyLinkedQueue() {
        super();
    }

    public void enQueue(T data) {
        insert(0, data);
    }

    public T deQueue() {
        if (isEmpty())
            return null;

        return remove(0);
    }

    public T front() {
        if (isEmpty())
            return null;

        return get(0);
    }
}
