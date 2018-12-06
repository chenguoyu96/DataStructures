package org.chenguoyu.datastructure.map;

/**
 * @author chenguoyu
 * @date 2018-12-05
 * @program DataStructures
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
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

        public Node(K key, V value) {
            this(key, value, null, null);
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
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
        return node;
    }

    @Override
    public boolean contains(K key) {
        return get(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.value;
    }

    private Node get(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return get(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V remove(K key) {
        Node node = remove(root, key);
        return node == null ? null : node.value;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            } else {
                Node minimum = minimum(node.right);
                minimum.right = removeMin(node.right);
                minimum.left = node.left;
                return minimum;
            }
        }
        return null;
    }

    private Node removeMin() {
        Node minimum = minimum(root);
        root = removeMin(root);
        return minimum;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            size--;
            return null;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node removeMax() {
        Node maximum = maximum(root);
        root = removeMax(root);
        return maximum;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            size--;
            return null;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node);
    }
}
