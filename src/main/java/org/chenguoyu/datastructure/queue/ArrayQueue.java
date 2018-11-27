package org.chenguoyu.datastructure.queue;

import org.chenguoyu.datastructure.arrays.Array;

/**
 * @author chenguoyu
 * @date 2018-11-27
 * @program DataStructures
 */
public class ArrayQueue<T> implements Queue<T> {
    private Array<T> array;

    public ArrayQueue() {
        this.array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayQueue(Array<T> array) {
        this.array = array;
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        array.addLast(e);
    }

    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.get(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue front [ ");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i)).append(" ");
        }
        sb.append(" ] tail");
        return sb.toString();
    }
}
