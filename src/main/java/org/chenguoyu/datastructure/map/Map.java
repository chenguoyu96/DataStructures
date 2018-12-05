package org.chenguoyu.datastructure.map;

public interface Map<K, V> {
    /**
     * 添加键值对
     *
     * @param key
     * @param value
     */
    void put(K key, V value);

    /**
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 获得元素个数
     *
     * @return
     */
    int size();

    /**
     * 查看map是否为空
     *
     * @return
     */
    boolean isEmpty();
}
