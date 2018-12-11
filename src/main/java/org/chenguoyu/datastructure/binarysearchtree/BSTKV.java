package org.chenguoyu.datastructure.binarysearchtree;

/**
 * 键值对的二分搜索树
 *
 * @author chenguoyu
 * @date 2018-11-29
 * @program DataStructures
 */
public class BSTKV<K extends Comparable<K>, V> {
    /**
     * 二分搜索树的节点信息
     */
    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Node(K key, V value) {
            this(key, value, null, null);
        }

        Node() {
            this(null, null, null, null);
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

    public BSTKV() {
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
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node root, K key, V value) {
        if (root == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(root.key) < 0) {
            root.left = put(root.left, key, value);
        } else if (key.compareTo(root.key) > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.value = value;
        }
        return root;
    }

    /**
     * 树中是否包含元素
     *
     * @param key
     * @return
     */
    public boolean contain(K key) {
        return contain(root, key);
    }

    private boolean contain(Node root, K key) {
        if (root == null) {
            return false;
        }
        if (root.key.compareTo(key) > 0) {
            return contain(root.left, key);
        } else if (root.key.compareTo(key) < 0) {
            return contain(root.right, key);
        } else {
            return true;
        }
    }

    /**
     * 移除最小的元素
     *
     * @return
     */
    private Node removeMin() {
        Node minimum = minimum(root);
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
    public Node removeMax() {
        Node maximum = maximum(root);
        root = removeMax(root);
        return maximum;
    }

    private Node removeMax(Node root) {
        if (root.right == null) {
            size--;
            return root.left;
        }
        root.right = removeMax(root.right);
        return root;
    }

    private Node maximum(Node root) {
        if (root.right == null) {
            return root;
        }
        return maximum(root.right);
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

    /**
     * 移除元素
     *
     * @param key
     */
    public void remove(K key) {
        root = remove(root, key);
    }

    private Node remove(Node root, K key) {
        if (root == null) {
            return null;
        }
        if (root.key.compareTo(key) > 0) {
            root.left = remove(root.left, key);
            return root;
        } else if (root.key.compareTo(key) < 0) {
            root.right = remove(root.right, key);
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
        result.append(generateDepthString(depth) + root.key + "\n");
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
