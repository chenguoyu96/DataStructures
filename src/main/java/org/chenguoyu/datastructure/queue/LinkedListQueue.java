package org.chenguoyu.datastructure.queue;

import org.chenguoyu.datastructure.linklist.LinkedList;

/**
 * @author chenguoyu
 * @date 2018-11-28
 * @program DataStructures
 */
public class LinkedListQueue<T> implements Queue<T> {
    private LinkedList<T> linkedList;

    public LinkedListQueue() {
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
    public void enqueue(T e) {
        linkedList.addLast(e);
    }

    @Override
    public T dequeue() {
        return linkedList.removeFirst();
    }

    @Override
    public T getFront() {
        return linkedList.get(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue front [ ");
        for (int i = 0; i < linkedList.getSize(); i++) {
            sb.append(linkedList.get(i)).append(" ");
        }
        sb.append(" ] tail");
        return sb.toString();
    }
}
