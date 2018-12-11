package org.chenguoyu.datastructure.avltree;

import org.chenguoyu.datastructure.FileOperation;
import org.chenguoyu.datastructure.map.AVLMap;
import org.chenguoyu.datastructure.map.BSTMap;
import org.chenguoyu.datastructure.map.LinkedListMap;
import org.chenguoyu.datastructure.map.Map;

import java.util.List;

/**
 * @author chenguoyu
 * @date 2018-12-11
 * @program DataStructures
 */
public class MapTest {
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
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");

        System.out.println();
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");

        System.out.println();

        AVLMap<String, Integer> avlMap = new AVLMap<>();
        double time3 = testMap(avlMap, filename);
        System.out.println("AVL Map: " + time3 + " s");
    }
}
