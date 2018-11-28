package org.chenguoyu.datastructure.queue;


/**
 * 循环队列
 *
 * @author chenguoyu
 * @date 2018-11-28
 * @program DataStructures
 */
public class LoopQueue<T> implements Queue<T> {
    private T[] values;
    private int front, tail;
    private int size;

    public LoopQueue() {
        values = (T[]) new Object[10];
        size = 0;
        front = 0;
        tail = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return values.length;
    }

    @Override
    public void enqueue(T e) {
        if ((tail + 1) % values.length == front) {
            resize(size * 2);
        }
        values[tail] = e;
        tail = (tail + 1) % values.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("队列为空");
        }
        T result = values[front];
        size--;
        front = (front + 1) % values.length;
        if (size <= values.length / 4 && size / 2 != 0) {
            resize(values.length / 2);
        }
        return result;
    }

    private void resize(int capacity) {
        T[] result = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            result[i] = values[(front + i) % values.length];
        }
        values = result;
        front = 0;
        tail = size;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new NullPointerException("队列为空");
        }
        return values[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoopQueue front [ ");
        for (int i = 0; i < size; i++) {
            sb.append(values[(front + i) % values.length]).append(" ");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
