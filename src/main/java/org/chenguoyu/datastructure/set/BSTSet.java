package org.chenguoyu.datastructure.set;

import org.chenguoyu.datastructure.tree.BST;

/**
 * 用二分搜索树实现堆
 *
 * @author chenguoyu
 * @date 2018-12-04
 * @program DataStructures
 */
public class BSTSet<T extends Comparable<T>> implements Set<T> {
    private BST<T> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(T e) {
        bst.add(e);
    }

    @Override
    public boolean contain(T e) {
        return bst.contain(e);
    }

    @Override
    public void remove(T e) {
        bst.remove(e);
    }

    @Override
    public int size() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
