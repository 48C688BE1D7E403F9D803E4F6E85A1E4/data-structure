package com.maxwit.listv10;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySequentialList<T> implements Iterable<T> {
    private Object[] eleData;
    private int size;
    private int capacity;
    private int incrCapacity;

    MySequentialList() {
        size = 0;
        capacity = 4;
        incrCapacity = 4;
        eleData = new Object[capacity];
    }

    private void capacityData() {
        int len = capacity + incrCapacity;
        Object[] tmp = new Object[len];
        for (int i = 0; i < eleData.length; i++) {
            tmp[i] = eleData[i];
        }
        eleData = tmp;
        capacity = len;
    }

    private Boolean isCapacity() {
        if (size + 1 >= capacity) {
            return true;
        }

        return false;
    }

    public int length() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Out Of Bound Exception");

        return (T) eleData[index];
    }

    public Boolean set(int index, int data) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Out Of Bound Exception");

        eleData[index] = data;
        return true;
    }

    public void insert(int index, int data) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Out Of Bound Exception");

        if (isCapacity())
            capacityData();

        for (int i = size; i >= index; i--) {
            eleData[i + 1] = eleData[i];
        }
        eleData[index] = data;
        size++;
    }

    public T remove(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Out Of Bound Exception");

        T data = (T) eleData[index];

        for (int i = index; i < size; i++)
            eleData[i] = eleData[i + 1];
        --size;

        return data;
    }

    public int removeAll() {
        int rs = size;
        size = 0;

        return rs;
    }

    public int contains(T data) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (eleData[i] == data)
                count++;
        }

        return count;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return (T) eleData[index++];
                }
                throw new NoSuchElementException("No Such Element Exception");
            }
        };
    }
}
