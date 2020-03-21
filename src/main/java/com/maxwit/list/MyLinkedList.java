package com.maxwit.list;

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
    private int size;

    MyLinkedList() {
        head = new Node();
        size = 0;
    }

    public void insert(T data) {
        Node tmp = new Node(data);
        tmp.next = head.next;
        head.next = tmp;
        size++;
    }

    public void traversal(Consumer<T> visit) {
        Node pNode;
        for (pNode = head.next; pNode != null; pNode = pNode.next) {
            visit.accept(pNode.data);
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node pNode = head.next;
            @Override
            public boolean hasNext() {
                return pNode !=null;
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
