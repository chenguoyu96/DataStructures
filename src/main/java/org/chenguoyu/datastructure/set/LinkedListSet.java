package org.chenguoyu.datastructure.set;

import org.chenguoyu.datastructure.linklist.LinkedList;

/**
 * @author chenguoyu
 * @date 2018-12-05
 * @program DataStructures
 */
public class LinkedListSet<T> implements Set<T> {
    private LinkedList<T> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(T e) {
        boolean contain = linkedList.contain(e);
        if (!contain) {
            linkedList.addLast(e);
        }
    }

    @Override
    public boolean contain(T e) {
        return linkedList.contain(e);
    }

    @Override
    public void remove(T e) {
        linkedList.remove(e);
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
