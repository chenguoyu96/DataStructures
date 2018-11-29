package org.chenguoyu.datastructure.binarysearchtree;

/**
 * 二分搜索树
 *
 * @author chenguoyu
 * @date 2018-11-29
 * @program DataStructures
 */
public class BST<T extends Comparable<T>> {
    private class Node {
        T value;
        Node left, right;

        Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Node(T value) {
            this(value, null, null);
        }

        Node() {
            this(null, null, null);
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T e) {
        add(root, e);
    }

    private void add(Node root, T e) {
        if (root.value.equals(e)) {
            return;
        } else if (root.value.compareTo(e) < 0 && root.left == null) {
            root.left = new Node(e);
            size++;
            return;
        } else if (root.value.compareTo(e) > 0 && root.right == null) {
            root.left = new Node(e);
            size++;
            return;
        }

        if (root.value.compareTo(e) < 0) {
            add(root.left, e);
        }
        if (root.value.compareTo(e) > 0) {
            add(root.right, e);
        }
    }

}
