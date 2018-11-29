package org.chenguoyu.datastructure.linklist;

/**
 * 链表
 *
 * @author chenguoyu
 * @date 2018-11-28
 * @program DataStructures
 */
public class LinkedList<T> {
    private class Node {
        T value;
        Node next;

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this(value, null);
        }

        Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node dummyHead, tail;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T e) {
        add(0, e);
    }

    public void addLast(T e) {
        add(size, e);
    }

    public void add(int index, T e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index 必须小于等于size且大于0");
        }
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        preNode.next = new Node(e, preNode.next);
        size++;
    }

    public T get(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index 必须小于等于size且大于0");
        }
        Node preNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        return preNode.value;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void set(int index, T e) {
        Node preNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        preNode.value = e;
    }

    public boolean contain(T e) {
        Node preNode = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (preNode.value.equals(e)) {
                return true;
            }
            preNode = preNode.next;
        }
        return false;
    }

    public T remove(int index) {
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node removeNode = preNode.next;
        if (preNode.next != null) {
            preNode.next = removeNode.next;
            size--;
        }
        return removeNode.value;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void remove(T e) {
        Node preNode = dummyHead;
        for (int i = 0; i < size; i++) {
            if (preNode.next.value.equals(e)) {
                break;
            }
            preNode = preNode.next;
        }
        if (preNode.next != null) {
            preNode.next = preNode.next.next;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList head [ ");
        Node node = dummyHead.next;
        for (int i = 0; i < size; i++) {
            sb.append(node.value.toString()).append(" ");
            node = node.next;
        }
        sb.append(" ] tail");
        return sb.toString();
    }
}
