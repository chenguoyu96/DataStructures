package org.chenguoyu.datastructure.map;

import org.chenguoyu.datastructure.tree.AVLTree;

/**
 * 使用AVL实现Map
 *
 * @author chenguoyu
 * @date 2018-12-11
 * @program DataStructures
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
    private AVLTree<K, V> tree;

    public AVLMap() {
        tree = new AVLTree<>();
    }

    @Override
    public void put(K key, V value) {
        tree.put(key, value);
    }

    @Override
    public V remove(K key) {
        return tree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return tree.contain(key);
    }

    @Override
    public V get(K key) {
        return tree.get(key);
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }
}
