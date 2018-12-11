package org.chenguoyu.datastructure.set;

import org.chenguoyu.datastructure.map.AVLMap;

/**
 * 使用AVLMap实现set
 *
 * @author chenguoyu
 * @date 2018-12-11
 * @program DataStructures
 */
public class MapToSet<T extends Comparable<T>> implements Set<T> {
    private AVLMap<T, Object> map;

    public MapToSet() {
        map = new AVLMap<>();
    }

    @Override
    public void add(T t) {
        map.put(t, null);
    }

    @Override
    public boolean contain(T t) {
        return map.contains(t);
    }

    @Override
    public void remove(T t) {
        map.remove(t);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
}
