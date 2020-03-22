package com.maxwit.tree;

import java.util.function.Consumer;

public class MyLinkedBT<T> {
    private class Node {
        T data;
        Node left;
        Node right;

        Node(T value) {
            data = value;
            left = null;
            right = null;
        }
    }

    protected Node root;

    public MyLinkedBT(T data) {
        root = new Node(data);
    }

    private Node rFindNode(Node r, T data) {
        if (r == null)
            return null;
        if (r.data.equals(data))
            return r;

        Node found = rFindNode(r.left, data);
        return found != null ? found : rFindNode(r.right, data);
    }

    private Node findNode(T data) {
        Node node = rFindNode(root, data);
        return node;
    }

    public Boolean insert(T rData, int lOrR, T data) {
        Node pNode = findNode(rData);
        if (pNode == null)
            return false;
        if (lOrR == 0) {
            if (pNode.left != null)
                return false;
            pNode.left = new Node(data);
        } else {
            if (pNode.right != null)
                return false;
            pNode.right = new Node(data);
        }

        return true;
    }

    private void rPreTraversal(Node r, Consumer<T> visit) {
        if (r == null)
            return;
        visit.accept(r.data);
        rPreTraversal(r.left, visit);
        rPreTraversal(r.right, visit);
    }

    public void preTraversal(Consumer<T> visit) {
        rPreTraversal(root, visit);
    }

    private void rInTraversal(Node r, Consumer<T> visit) {
        if (r == null)
            return;
        rInTraversal(r.left, visit);
        visit.accept(r.data);
        rInTraversal(r.right, visit);
    }

    public void inTraversal(Consumer<T> visit) {
        rInTraversal(root, visit);
    }

    private void rLastTraversal(Node r, Consumer<T> visit) {
        if (r == null)
            return;
        rLastTraversal(r.left, visit);
        rLastTraversal(r.right, visit);
        visit.accept(r.data);
    }

    public void lastTraversal(Consumer<T> visit) {
        rLastTraversal(root, visit);
    }
}
