package org.chenguoyu.datastructure.tree;

import java.util.function.BiFunction;

/**
 * 线段树
 *
 * @author chenguoyu
 * @date 2018-12-06
 * @program DataStructures
 */
public class SegmentTree<T> {
    private T[] tree;
    private T[] data;
    private BiFunction<T, T, T> merge;

    public SegmentTree(T[] data, BiFunction<T, T, T> merge) {
        this.data = (T[]) new Object[data.length];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
        tree = (T[]) new Object[data.length * 4];
        this.merge = merge;
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 获得元素个数
     *
     * @return
     */
    public int size() {
        return data.length;
    }

    /**
     * 获得index索引的数据
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return data[index];
    }

    /**
     * 获得index索引的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 获得index索引的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 构建线段树
     *
     * @param index
     * @param l
     * @param r
     */
    private void buildSegmentTree(int index, int l, int r) {
        if (l == r) {
            tree[index] = data[l];
            return;
        }
        int mid = l + (r - l) / 2;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        buildSegmentTree(leftChild, l, mid);
        buildSegmentTree(rightChild, mid + 1, r);
        tree[index] = merge.apply(tree[leftChild], tree[rightChild]);
    }

    public T query(int queryL, int queryR) {
        if (queryL < 0 || queryR > size() || queryL > queryR) {
            throw new IllegalArgumentException("queryL或queryR是无效的");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private T query(int index, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[index];
        }
        int mid = l + (r - l) / 2;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        if (queryL > mid) {
            return query(rightChild, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftChild, l, mid, queryL, queryR);
        }
        T right = query(rightChild, mid + 1, r, mid + 1, queryR);
        T left = query(leftChild, l, mid, queryL, mid);
        return merge.apply(right, left);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[ ");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]).append(" ");
            } else {
                res.append("null").append(" ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
