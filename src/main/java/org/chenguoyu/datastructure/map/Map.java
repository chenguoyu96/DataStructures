package org.chenguoyu.datastructure.map;

public interface Map<K, V> {
    /**
     * 添加键值对
     *
     * @param key
     * @param value
     */
    void add(K key, V value);

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
     * @param key
     * @param newValue
     */
    void set(K key, V newValue);

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
