package org.chenguoyu.datastructure.queue;

/**
 * @author chenguoyu
 * @date 2018-11-27
 * @program DataStructures
 */
public interface Queue<T> {
    /**
     * 获得元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 元素入队
     *
     * @param e
     */
    void enqueue(T e);

    /**
     * 元素出队
     *
     * @return
     */
    T dequeue();

    /**
     * 获得队首元素
     *
     * @return
     */
    T getFront();
}
