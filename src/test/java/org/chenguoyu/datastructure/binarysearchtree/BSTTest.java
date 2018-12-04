package org.chenguoyu.datastructure.binarysearchtree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author chenguoyu
 * @date 2018-11-29
 * @program DataStructures
 */
public class BSTTest {

    BST<Integer> bst = new BST<>();

    // 打乱数组顺序
    private static void shuffle(Object[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }

    /**
     * /////////////////
     * //      5      //
     * //    /   \    //
     * //   3    6    //
     * //  / \    \   //
     * // 2  4     8  //
     * /////////////////
     */
    @Test
    public void testOrder() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);


        System.out.print("二分搜索树的前序遍历");
        bst.preOrder();
        System.out.println();
        System.out.print("二分搜索树的非递归前序遍历");
        bst.preOrderNR();
        System.out.println();

        System.out.print("二分搜索树的中序遍历");
        bst.inOrder();
        System.out.println();

        System.out.print("二分搜索树的后序遍历");
        bst.postOrder();
        System.out.println();

        System.out.print("二分搜索树的层序遍历");
        bst.levelOrder();
        System.out.println();


        System.out.println(bst);
    }

    @Before
    public void createBST() {
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++)
            bst.add(random.nextInt(10000));
    }

    @Test
    public void testRemoveMin() {
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty())
            nums.add(bst.removeMin());
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++)
            if (nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("Error!");
            }
        System.out.println("removeMin test completed.");
    }

    @Test
    public void testRemoveMax() {
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty())
            nums.add(bst.removeMax());

        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++)
            if (nums.get(i - 1) < nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMax test completed.");
    }

    @Test
    public void testRemove() {

        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;

        for (int i = 0; i < n; i++)
            bst.add(random.nextInt(n));

        /*
         * 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的
         * order数组中存放[0...n)的所有元素
         */
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++)
            order[i] = i;
        // 打乱order数组的顺序
        shuffle(order);

        // 乱序删除[0...n)范围里的所有元素
        for (int i = 0; i < n; i++)
            if (bst.contain(order[i])) {
                bst.remove(order[i]);
                System.out.println("After remove " + order[i] + ", size = " + bst.size());
            }

        // 最终整个二分搜索树应该为空
        System.out.println(bst.size());
    }
}
