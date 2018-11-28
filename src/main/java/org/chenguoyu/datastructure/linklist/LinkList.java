package org.chenguoyu.datastructure.linklist;

/**
 * 链表
 *
 * @author chenguoyu
 * @date 2018-11-28
 * @program DataStructures
 */
public class LinkList<T> {
    private class Node<T> {
        public T value;
        public Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this(value, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node<T> head, tail;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T e) {
        head = new Node<>(e, head);
        size++;
    }

    public void addLast(T e) {
        add(size, e);
    }

    public void add(int index, T e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index 必须小于等于size且大于0");
        }
        if (size == 0) {
            addFirst(e);
        } else {
            Node<T> preNode = head;
            for (int i = 0; i < index - 1; i++) {
                preNode = preNode.next;
            }
            preNode.next = new Node<>(e, preNode.next);
            size++;
        }
    }

    public int find(T e) {
        Node<T> preNode = head;
        for (int i = 0; i < size; i++) {
            if (preNode.value.equals(e)) {
                return i;
            }
            preNode = preNode.next;
        }
        return -1;
    }

    public boolean contain(T e) {
        int i = find(e);
        return i > -1;
    }
}