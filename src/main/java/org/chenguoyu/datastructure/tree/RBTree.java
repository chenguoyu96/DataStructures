package org.chenguoyu.datastructure.tree;

/**
 * 红黑树
 * 红黑树的五个性质
 * 1. 每个节点为红色的，或者是黑色的
 * 2. 根节点是黑色的
 * 3. 每个叶子节点(最后的空节点)是黑色的
 * 4. 如果一个节点是红色的，则它的两个子节点都是黑色的
 * 5. 对于每个节点，该节点到后代的节点所经过了黑色节点数量是相同的(黑平衡)
 *
 * @author chenguoyu
 * @date 2018-12-13
 * @program DataStructures
 */
public class RBTree<K extends Comparable, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        K key;
        V value;
        Node left, right;
        boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    private Node root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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

    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    /**
     * 添加元素
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    /*等同于在二三树的三节点的右侧添加元素 这时不需要进行右旋转，只需要进行颜色的翻转即可
     *      node                   node
     *     /   \     右旋转        /   \
     *    x     Y   ------->     x     Y
     */

    /**
     * 颜色翻转
     * 等同于在二三树中的三节点添加一个元素，使他变成一个临时的四节点，这时需要进行颜色的翻转
     *
     * @param node
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
    /* x为添加的元素，为保证红色节点左倾，需要进行左旋转 并且将x的颜色与node的颜色互换
     * 等同于像二三数中的二节点添加元素，将二节点变成三节点
     *   node                     x
     *  /   \     左旋转         /  \
     * T1   x   --------->   node   T3
     *     / \              /   \
     *    T2 T3            T1   T2
     */

    /**
     * 左旋转
     *
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {
        Node x = node.right;

        // 左旋转
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }
    /* y为新添加的元素
     * 等同于在二三树中的三节点添加一个元素，使他变成一个临时的四节点，这时需要进行又旋转，然后进行颜色的翻转
     *      node                   x
     *     /   \     右旋转       /  \
     *    x    T2   ------->   y   node
     *   / \                       /  \
     *  y  T1                     T1  T2
     */

    /**
     * 右旋转
     *
     * @param node
     * @return
     */
    private Node rightRotate(Node node) {

        Node x = node.left;

        // 右旋转
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
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

        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }
}
