package org.chenguoyu.datastructure.map;

import org.chenguoyu.datastructure.FileOperation;

import java.util.List;

/**
 * @author chenguoyu
 * @date 2018-12-11
 * @program DataStructures
 */
public class AVLMapTest {
    private static double testMap(Map<String, Integer> map, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        List<String> words = FileOperation.readFile(filename);
        System.out.println("Total words: " + words.size());

        for (String word : words) {
            if (map.contains(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        System.out.println("Total different words: " + map.size());
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "pride-and-prejudice.txt";

        AVLMap<String, Integer> avlMap = new AVLMap<>();
        double time3 = testMap(avlMap, filename);
        System.out.println("AVL Map: " + time3 + " s");
    }
}
