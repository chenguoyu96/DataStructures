package org.chenguoyu.datastructure.stack;

/**
 * @author chenguoyu
 * @date 2018-11-27
 * @program DataStructures
 */
public interface Stack<E> {
    /**
     * 获得元素个数
     *
     * @return
     */
    int getSize();

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
    void push(E e);

    /**
     * 将栈顶元素弹出
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();
}
