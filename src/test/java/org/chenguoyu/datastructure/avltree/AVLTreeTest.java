package org.chenguoyu.datastructure.avltree;

import org.chenguoyu.datastructure.FileOperation;
import org.chenguoyu.datastructure.binarysearchtree.BSTKV;

import java.util.Collections;
import java.util.List;

/**
 * @author chenguoyu
 * @date 2018-12-11
 * @program DataStructures
 */
public class AVLTreeTest {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        List<String> words = FileOperation.readFile("pride-and-prejudice.txt");
        System.out.println("Total words: " + words.size());

         Collections.sort(words);

        // Test BST
        long startTime = System.nanoTime();

        BSTKV<String, Integer> bst = new BSTKV<>();
        for (String word : words) {
            if (bst.contain(word))
                bst.put(word, bst.get(word) + 1);
            else
                bst.put(word, 1);
        }

        for (String word : words)
            bst.contain(word);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST: " + time + " s");


        // Test AVL
        startTime = System.nanoTime();

        AVLTree<String, Integer> avl = new AVLTree<>();
        for (String word : words) {
            if (avl.contain(word))
                avl.put(word, avl.get(word) + 1);
            else
                avl.put(word, 1);
        }

        for (String word : words)
            avl.contain(word);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");


        System.out.println();
    }
}
