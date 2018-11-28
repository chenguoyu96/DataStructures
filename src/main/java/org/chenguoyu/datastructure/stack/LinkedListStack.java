package org.chenguoyu.datastructure.stack;

import org.chenguoyu.datastructure.linklist.LinkedList;

/**
 * @author chenguoyu
 * @date 2018-11-28
 * @program DataStructures
 */
public class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(T e) {
        linkedList.addFirst(e);
    }

    @Override
    public T pop() {
        return linkedList.removeFirst();
    }

    @Override
    public T peek() {
        return linkedList.get(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack [ ");
        for (int i = 0; i < linkedList.getSize(); i++) {
            sb.append(linkedList.get(i)).append(" ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
