package org.chenguoyu.datastructure.heap;

import org.chenguoyu.datastructure.arrays.Array;

/**
 * @author chenguoyu
 * @date 2018-12-06
 * @program DataStructures
 */
public class MaxHeap<T extends Comparable<T>> {
    private Array<T> array;

    public MaxHeap(int capacity) {
        this.array = new Array<>(capacity);
    }

    public MaxHeap() {
        this.array = new Array<>();
    }

    public int size() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 返回父节点的索引
     *
     * @param index
     * @return
     */
    public int parent(int index) {
        if (index == 0) {
            throw new NullPointerException("根节点没有父节点");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回左边孩子节点的索引
     *
     * @return
     */
    public int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回右边孩子节点的索引
     *
     * @param index
     * @return
     */
    public int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 添加元素
     *
     * @param e
     */
    public void add(T e) {
        array.addLast(e);
        siftUp(array.size() - 1);
    }

    /**
     * 上浮
     * 如果添加的节点比父节点要大，则与父节点交换
     *
     * @param i
     */
    private void siftUp(int i) {
        while (i > 0 && array.get(i).compareTo(array.get(parent(i))) > 0) {
            array.swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * 取出堆中最大的元素
     *
     * @return
     */
    public T extractMax() {
        T ret = findMax();
        array.swap(0, size() - 1);
        array.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 下沉
     * 如果左右孩子节点比i节点大，则将i与左右孩子节点中大的节点交换
     *
     * @param i
     */
    private void siftDown(int i) {
        while (leftChild(i) < size()) {
            int j = leftChild(i);
            //j+1其实是右孩子节点
            if (j + 1 < array.size() && array.get(j).compareTo(array.get(j + 1)) < 0) {
                j++;
            }
            if (array.get(i).compareTo(array.get(j)) > 0) {
                break;
            }
            array.swap(i, j);
            i = j;
        }
    }

    public T findMax() {
        if (size() == 0) {
            throw new NullPointerException();
        }
        return array.get(0);
    }
}
