package org.chenguoyu.datastructure.arrays;

/**
 * @author chenguoyu
 * @date 2018-11-26
 * @program DataStructures
 */
public class Array<T> {
    private int size;
    private T[] values;

    public Array(int capacity) {
        this.size = 0;
        this.values = (T[]) new Object[capacity];
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    /**
     * 获得数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return values.length;
    }

    /**
     * 获得元素个数
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在数组末尾添加一个元素
     *
     * @param e
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 在数组开头添加一个元素
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 在指定位置添加一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (getCapacity() == size) {
            resize(size * 2);
        }
        if (size == values.length) {
            resize(size * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            values[i + 1] = values[i];
        }
        values[index] = e;
        size++;
    }

    /**
     * 查询元素e所在的索引
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获得指定位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引地址不能小于0,或者大于数组大小");
        }
        return values[index];
    }

    /**
     * 修改指定位置的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引地址不能小于0,或者大于数组大小");
        }
        values[index] = e;
    }

    /**
     * 删除元素
     *
     * @param e
     */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 删除index位置的索引
     *
     * @param index
     */
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引地址不能小于0,或者大于数组大小");
        }
        T e = values[index];
        for (int i = index; i < values.length - 1; i++) {
            values[i] = values[i + 1];
        }
        size--;
        if (size <= values.length / 4 && values.length / 2 != 0) {
            resize(values.length / 2);
        }
        return e;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contain(T e) {
        for (T value : values) {
            if (value.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 拓展数组
     *
     * @param capacity
     */
    private void resize(int capacity) {
        T[] newDatas = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newDatas[i] = this.values[i];
        }
        this.values = newDatas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d,capacity = %d\n", size, getCapacity()));
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(values[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
