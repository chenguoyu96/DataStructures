package org.chenguoyu.datastructure.set;

import org.chenguoyu.datastructure.FileOperation;

import java.util.List;

/**
 * @author chenguoyu
 * @date 2018-12-11
 * @program DataStructures
 */
public class AVLSetTest {
    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();
        System.out.println(filename);
        List<String> words = FileOperation.readFile(filename);
        System.out.println("Total words: " + words.size());

        for (String word : words)
            set.add(word);
        System.out.println("Total different words: " + set.size());

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "pride-and-prejudice.txt";

        MapToSet<String> avlSet = new MapToSet<>();
        double time3 = testSet(avlSet, filename);
        System.out.println("AVL Set: " + time3 + " s");
    }
}
