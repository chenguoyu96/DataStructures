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

    private Node add(Node root, T e) {
        if (root==null) {
            size++;
            return new Node(e);
        }
        if (root.value.compareTo(e) < 0) {
            root.left =add(root.left, e);
        }
        if (root.value.compareTo(e) > 0) {
            root.right = add(root.right, e);
        }
        return root;
    }

}
