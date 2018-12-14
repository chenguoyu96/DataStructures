package org.chenguoyu.datastructure.tree;

import org.chenguoyu.datastructure.queue.LinkedListQueue;
import org.chenguoyu.datastructure.queue.Queue;
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
    /**
     * 二分搜索树的节点信息
     */
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

    /**
     * 根节点
     */
    private Node root;
    /**
     * 树中的元素数量
     */
    private int size;

    public BST() {
        this.root = null;
        size = 0;
    }

    /**
     * 返回元素数量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     *
     * @param e
     */
    public void add(T e) {
        root = add(root, e);
    }

    private Node add(Node root, T e) {
        if (root == null) {
            size++;
            return new Node(e);
        }
        if (root.value.compareTo(e) > 0) {
            root.left = add(root.left, e);
        } else if (root.value.compareTo(e) < 0) {
            root.right = add(root.right, e);
        }
        return root;
    }

    /**
     * 树中是否包含元素
     *
     * @param e
     * @return
     */
    public boolean contain(T e) {
        return contain(root, e);
    }

    private boolean contain(Node root, T e) {
        if (root == null) {
            return false;
        }
        if (root.value.compareTo(e) > 0) {
            return contain(root.left, e);
        } else if (root.value.compareTo(e) < 0) {
            return contain(root.right, e);
        } else {
            return true;
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 非递归的前序遍历 使用栈
     */
    public void preOrderNR() {
        Stack<Node> stack = new LinkedListStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.value + " ");
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedListQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
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
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    /**
     * 移除最小的元素
     *
     * @return
     */
    public T removeMin() {
        T minimum = minimum();
        root = removeMin(root);
        return minimum;
    }

    private Node removeMin(Node root) {
        if (root.left == null) {
            size--;
            return root.right;
        }
        root.left = removeMin(root.left);
        return root;
    }

    /**
     * 查找最小的元素
     *
     * @return
     */
    public T minimum() {
        if (isEmpty()) {
            throw new NullPointerException("BST is empty");
        }
        return minimum(root).value;
    }

    private Node minimum(Node root) {
        if (root.left == null) {
            return root;
        }
        return minimum(root.left);
    }

    /**
     * 移除最大的元素
     *
     * @return
     */
    public T removeMax() {
        T maximum = maximum();
        root = removeMax(root);
        return maximum;
    }

    public Node removeMax(Node root) {
        if (root.right == null) {
            size--;
            return root.left;
        }
        root.right = removeMax(root.right);
        return root;
    }

    /**
     * 查找最大的元素
     *
     * @return
     */
    public T maximum() {
        if (isEmpty()) {
            throw new NullPointerException("二分搜索树为空");
        }
        return maximum(root).value;
    }

    private Node maximum(Node root) {
        if (root.right == null) {
            return root;
        }
        return maximum(root.right);
    }

    /**
     * 移除元素
     *
     * @param e
     */
    public void remove(T e) {
        root = remove(root, e);
    }

    private Node remove(Node root, T e) {
        if (root == null) {
            return null;
        }
        if (root.value.compareTo(e) > 0) {
            root.left = remove(root.left, e);
            return root;
        } else if (root.value.compareTo(e) < 0) {
            root.right = remove(root.right, e);
            return root;
        } else {
            if (root.left == null) {
                size--;
                return root.right;
            } else if (root.right == null) {
                size--;
                return root.left;
            } else {
                /*
                 * 查找到右子树的最小的节点
                 * 将右子树最小的节点替换到被删除的节点的位置
                 */
                Node minimum = minimum(root.right);
                minimum.right = removeMin(root.right);
                minimum.left = root.left;
                return minimum;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateString(root, 0, sb);
        return sb.toString();
    }

    private void generateString(Node root, int depth, StringBuilder result) {
        if (root == null) {
            result.append(generateDepthString(depth) + "NULL\n");
            return;
        }
        result.append(generateDepthString(depth) + root.value + "\n");
        generateString(root.left, depth + 1, result);
        generateString(root.right, depth + 1, result);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
