package com.maxwit.listv10;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        Node() {
            data = null;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    MyLinkedList() {
        tail = head = new Node();
        size = 0;
    }

    public Boolean isEmpty() {
        return tail == head;
    }

    public int length() {
        return size;
    }

    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Out of Bound");

        Node pNode = head.next;
        for (int i = 0; pNode != null; pNode = pNode.next) {
            if (i == index)
                return pNode.data;
            i++;
        }
        throw new NoSuchElementException();
    }

    public Boolean set(int index, T data) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Out of Bound");

        Node pNode = head.next;
        for (int i = 0; pNode != null; pNode = pNode.next) {
            if (i == index) {
                pNode.data = data;
                return true;
            }
            i++;
        }

        return false;
    }

    public void insert(T data) {
        Node tmp = new Node(data);
        if (isEmpty())
            tail = tmp;

        tmp.next = head.next;
        head.next = tmp;
        size++;
    }

    public void insert(int index, T data) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Out of Bound");

        Node kNode = null;
        if (index == 0)
            kNode = head;
        else
            kNode = findK(index - 1);

        if (kNode != null) {
            Node tmp = new Node(data);
            if (kNode.next == null)
                tail = tmp;

            tmp.next = kNode.next;
            kNode.next = tmp;
            size++;
        }
    }

    public void traversal(Consumer<T> visit) {
        Node pNode;
        for (pNode = head.next; pNode != null; pNode = pNode.next) {
            visit.accept(pNode.data);
        }
    }

    private Node findK(int k) {
        Node pNode = head.next;
        int i = 0;
        while (pNode != null && i < k) {
            pNode = pNode.next;
            i++;
        }

        return pNode;
    }

    public T remove(int index) {
        if (isEmpty() || index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Out of Bound");

        T data = null;
        Node kNode = null;
        if (index == 0) {
            kNode = head;
        } else {
            kNode = findK(index - 1);
        }

        if (kNode != null && kNode.next != null) {
            if (index == size - 1) {
                tail = kNode;
            }
            data = kNode.next.data;
            kNode.next = kNode.next.next;
            size--;
        }

        return data;
    }

    public int removeAll() {
        int rs = size;
        head.next = null;
        tail = head;
        size = 0;

        return rs;
    }

    public int contains(T data) {
        Node pNode;
        int count = 0;
        for (pNode = head.next; pNode != null; pNode = pNode.next) {
            if (pNode.data.equals(data))
                count++;
        }

        return count;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node pNode = head.next;

            @Override
            public boolean hasNext() {
                return pNode != null;
            }

            @Override
            public T next() {
                T data = pNode.data;
                pNode = pNode.next;
                return data;
            }
        };
    }

}
