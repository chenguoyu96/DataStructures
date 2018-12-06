package org.chenguoyu.datastructure.queue;

import org.chenguoyu.datastructure.heap.MaxHeap;

/**
 * @author chenguoyu
 * @date 2018-12-06
 * @program DataStructures
 */
public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {
    private MaxHeap<T> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    public PriorityQueue(int capacity) {
        maxHeap = new MaxHeap<>(capacity);
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        maxHeap.add(e);
    }

    @Override
    public T dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public T getFront() {
        return maxHeap.findMax();
    }
}
