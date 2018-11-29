package org.chenguoyu.datastructure.binarysearchtree;

import org.chenguoyu.datastructure.stack.LinkedListStack;
import org.chenguoyu.datastructure.stack.Stack;

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
        this.root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T e) {
        root = add(root, e);
    }

    private Node add(Node root, T e) {
        if (root == null) {
            size++;
            return new Node(e);
        }
        if (root.value.compareTo(e) < 0) {
            root.left = add(root.left, e);
        } else if (root.value.compareTo(e) > 0) {
            root.right = add(root.right, e);
        }
        return root;
    }

    public boolean contain(T e) {
        return contain(root, e);
    }

    public boolean contain(Node root, T e) {
        if (root == null) {
            return false;
        }
        if (root.value.equals(e)) {
            return true;
        } else if (root.value.compareTo(e) < 0) {
            return contain(root.left, e);
        } else {
            return contain(root.right, e);
        }
    }


    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 非递归的前序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new LinkedListStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.value);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.println(root.value);
        preOrder(root.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.value);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
