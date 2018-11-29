package org.chenguoyu.datastructure.binarysearchtree;

import org.junit.Test;

/**
 * @author chenguoyu
 * @date 2018-11-29
 * @program DataStructures
 */
public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
//        bst.preOrder();
        bst.inOrder();
//        bst.postOrder();
        System.out.println();

        System.out.println(bst);
    }
}
