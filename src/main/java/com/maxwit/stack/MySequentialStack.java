package com.maxwit.stack;

import com.maxwit.list.MySequentialList;

public class MySequentialStack<T> extends MySequentialList<T> {

    MySequentialStack() {
        super();
    }

    public void push(T data) {
        insert(size, data);
    }

    public T pop() {
        if (isEmpty())
            return null;

        return remove(size - 1);
    }

    public T peek() {
        if (isEmpty())
            return null;

        return get(size - 1);
    }
}
