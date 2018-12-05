package org.chenguoyu.datastructure.map;

/**
 * @author chenguoyu
 * @date 2018-12-05
 * @program DataStructures
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Node(K key, V value) {
            this(key, value, null);
        }

        Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    /**
     * 虚拟头结点
     */
    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        boolean contains = contains(key);
        if (!contains) {
            addFirst(key, value);
        }
    }

    private void addFirst(K key, V value) {
        dummyHead.next = new Node(key, value, dummyHead.next);
        size++;
    }

    @Override
    public V remove(K key) {
        for (Node preNode = dummyHead; preNode.next != null; preNode = preNode.next) {
            if (preNode.next.key.equals(key)) {
                size--;
                Node removeNode = preNode.next;
                preNode.next = preNode.next.next;
                return removeNode.value;
            }
        }
        return null;
    }

    private Node getNode(K key) {
        for (Node curr = dummyHead.next; curr != null; curr = curr.next) {
            if (curr.key.equals(key)) {
                return curr;
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node != null) {
            node.value = newValue;
        }
        throw new IllegalArgumentException(key + " doesn't exist!");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
