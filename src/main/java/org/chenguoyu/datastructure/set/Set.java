package org.chenguoyu.datastructure.set;

public interface Set<T> {
    /**
     * 添加元素
     *
     * @param t
     */
    void add(T t);

    /**
     * 是否包含元素
     *
     * @param t
     * @return
     */
    boolean contain(T t);

    /**
     * 删除元素
     *
     * @param t
     */
    void remove(T t);

    /**
     * 包含元素个数
     *
     * @return
     */
    int size();

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();
}
