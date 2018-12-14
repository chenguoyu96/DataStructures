package org.chenguoyu.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * AVL树,平衡二叉树
 *
 * @author chenguoyu
 * @date 2018-12-10
 * @program DataStructures
 */
public class AVLTree<K extends Comparable, V> {
    private class Node {
        K key;
        V value;
        Node left, right;
        int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * 判断AVL树是不是一颗二分搜索树
     *
     * @return
     */
    public boolean isBST() {
        List<K> keys = new ArrayList<>(size);
        inOrder(root, keys);
        for (int i = 0; i < keys.size() - 1; i++) {
            if (keys.get(i).compareTo(keys.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断AVLtree是不是平衡二叉树
     *
     * @return
     */
    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }
        if (Math.abs(getBalanceFactor(node)) > 1) {
            return false;
        }
        return isBalance(node.left) && isBalance(node.right);
    }

    private void inOrder(Node node, List<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获得节点的高度
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 计算平衡因子
     * 左子树的高度减去右子树的高度
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * 添加元素
     * 如果已经存在这个元素，则更新
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = put(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balanceFactor = getBalanceFactor(node);
        /*添加的元素在需要维护平衡性的节点的左侧的左侧
         *         y                              x
         *        / \                           /   \
         *      x   T4     向右旋转 (y)        z     y
         *     / \       - - - - - - - ->    / \   / \
         *    z   T3                       T1  T2 T3 T4
         *   / \
         * T1   T2
         */
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        /* 添加的元素在需要维护平衡性的节点的右侧的右侧
         *     y                             x
         *   /  \                          /   \
         *  T1   x      向左旋转 (y)       y     z
         *      / \   - - - - - - - ->   / \   / \
         *    T2  z                     T1 T2 T3 T4
         *       / \
         *      T3 T4
         */
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        /* 添加的元素在需要维护的平衡性节点的左侧的右侧
         * 先进行左旋转，然后进行右旋转
         *      y                             y                                z
         *    /  \                          /   \                            /   \
         *   x    T4      向左旋转 (y)      z     T4     向右旋转 (y)         x      y
         *  /  \        - - - - - - - ->  /  \        - - - - - - - ->     /  \   / \
         * T1   z                        x   T3                           T1  T2 T3 T4
         *    /  \                      /  \
         *   T2  T2                    T1  T2
         */
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        /* 添加的元素在需要维护的平衡性节点的右侧的左侧
         * 先进行右旋转，然后进行左旋转
         *      y                                   y                                       Z
         *     /  \                                /  \                                    /  \
         *    T1   x                              T1   z                                  y     x
         *        /  \       向右旋转 (y)              /  \          向左旋转 (y)          /  \  /  \
         *       z    T4   - - - - - - - ->          T2   x       - - - - - - - ->      T1  T2 T3 T4
         *      /  \                                     /  \
         *     T2  T3                                   T3  T4
         */
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 对节点y进行向左旋转操作，返回旋转后新的根节点x
     *
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;
        //更新高度
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * 对节点y进行向右旋转操作，返回旋转后新的根节点x
     *
     * @param y
     * @return
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return x;
    }

    /**
     * 是否包含key为键的元素
     *
     * @param key
     * @return
     */
    public boolean contain(K key) {
        return getNode(root, key) != null;
    }

    /**
     * 查找key为键的元素
     *
     * @param key
     * @return
     */
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        }
        return node;
    }

    private Node minimum() {
        return minimum(root);
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node maximum() {
        return maximum(root);
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    private void removeMax() {
        root = removeMax(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            size--;
            return null;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private void removeMin() {
        root = removeMin(root);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            size--;
            return null;
        }
        node.left = removeMax(node.left);
        return node;
    }

    public V remove(K key) {
        Node node = remove(root, key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        Node resultNode = null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                size--;
                resultNode = node.right;
            }
            if (node.right == null) {
                size--;
                resultNode = node.left;
            }
            Node minimum = minimum(node.right);
            minimum.left = node.left;
            minimum.right = removeMin(node.right);
            resultNode = minimum;
        }
        if (resultNode == null) {
            return null;
        }
        resultNode.height = Math.max(getHeight(resultNode.left), getHeight(resultNode.right)) + 1;
        int balanceFactor = getBalanceFactor(resultNode);
        /*添加的元素在需要维护平衡性的节点的左侧的左侧
         *         y                              x
         *        / \                           /   \
         *      x   T4     向右旋转 (y)        z     y
         *     / \       - - - - - - - ->    / \   / \
         *    z   T3                       T1  T2 T3 T4
         *   / \
         * T1   T2
         */
        if (balanceFactor > 1 && getBalanceFactor(resultNode.left) >= 0) {
            return rightRotate(resultNode);
        }
        /* 添加的元素在需要维护平衡性的节点的右侧的右侧
         *     y                             x
         *   /  \                          /   \
         *  T1   x      向左旋转 (y)       y     z
         *      / \   - - - - - - - ->   / \   / \
         *    T2  z                     T1 T2 T3 T4
         *       / \
         *      T3 T4
         */
        if (balanceFactor < -1 && getBalanceFactor(resultNode.right) <= 0) {
            return leftRotate(resultNode);
        }
        /* 添加的元素在需要维护的平衡性节点的左侧的右侧
         * 先进行左旋转，然后进行右旋转
         *      y                             y                                z
         *    /  \                          /   \                            /   \
         *   x    T4      向左旋转 (y)      z     T4     向右旋转 (y)         x      y
         *  /  \        - - - - - - - ->  /  \        - - - - - - - ->     /  \   / \
         * T1   z                        x   T3                           T1  T2 T3 T4
         *    /  \                      /  \
         *   T2  T2                    T1  T2
         */
        if (balanceFactor > 1 && getBalanceFactor(resultNode.left) < 0) {
            resultNode.left = leftRotate(resultNode.left);
            return rightRotate(resultNode);
        }
        /* 添加的元素在需要维护的平衡性节点的右侧的左侧
         * 先进行右旋转，然后进行左旋转
         *      y                                   y                                       Z
         *     /  \                                /  \                                    /  \
         *    T1   x                              T1   z                                  y     x
         *        /  \       向右旋转 (y)              /  \          向左旋转 (y)          /  \  /  \
         *       z    T4   - - - - - - - ->          T2   x       - - - - - - - ->      T1  T2 T3 T4
         *      /  \                                     /  \
         *     T2  T3                                   T3  T4
         */
        if (balanceFactor < -1 && getBalanceFactor(resultNode.right) > 0) {
            resultNode.right = rightRotate(resultNode.right);
            return leftRotate(resultNode);
        }
        return resultNode;
    }


}
