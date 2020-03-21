package com.maxwit.list;

public class MySequentialList<T> {
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
        return size + 1;
    }

    public Boolean insert(int data) {
        if (isCapacity())
            capacityData();

        eleData[size++] = data;

        return true;
    }

    public Boolean insert(int index, int data) {
        if (index > size || index < 0)
            return false;

        if (isCapacity())
            capacityData();

        for (int i = size; i >= index; i--) {
            eleData[i + 1] = eleData[i];
        }
        eleData[index] = data;
        size++;

        return true;
    }

    public void remove() {
        --size;
    }

    public Boolean remove(int index) {
        if (index > size || index < 0)
            return false;

        for (int i = index; i < size; i++)
            eleData[i] = eleData[i + 1];
        --size;
        return true;
    }

    public void traversal() {
        for (int i = 0; i < size; i++) {
            System.out.print(eleData[i] + " ");
        }
        System.out.println();
    }
}
