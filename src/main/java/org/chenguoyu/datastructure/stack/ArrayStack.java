package org.chenguoyu.datastructure.stack;

import org.chenguoyu.datastructure.arrays.Array;

/**
 * @author chenguoyu
 * @date 2018-11-27
 * @program DataStructures
 */
public class ArrayStack<T> implements Stack<T> {
    private Array<T> array;

    public ArrayStack() {
        this.array = new Array<>();
    }

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack(Array<T> array) {
        this.array = array;
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(T e) {
        array.addFirst(e);
    }

    @Override
    public T pop() {
        return array.removeFirst();
    }

    @Override
    public T peek() {
        return array.get(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:[ ");
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i)).append(" ");
        }
        sb.append(" ] Top");
        return sb.toString();
    }
}
