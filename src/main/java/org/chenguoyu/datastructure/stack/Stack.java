package org.chenguoyu.datastructure.stack;

/**
 * @author chenguoyu
 * @date 2018-11-27
 * @program DataStructures
 */
public interface Stack<T> {
    /**
     * 获得元素个数
     *
     * @return
     */
    int size();

    /**
     * 判断栈是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 将e元素压入栈
     *
     * @param e
     */
    void push(T e);

    /**
     * 将栈顶元素弹出
     *
     * @return
     */
    T pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    T peek();
}
