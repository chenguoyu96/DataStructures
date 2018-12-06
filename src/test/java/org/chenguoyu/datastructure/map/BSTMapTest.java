package org.chenguoyu.datastructure.map;

import org.chenguoyu.datastructure.FileOperation;

import java.util.List;

/**
 * @author chenguoyu
 * @date 2018-12-06
 * @program DataStructures
 */
public class BSTMapTest {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        List<String> words = FileOperation.readFile("pride-and-prejudice.txt");
        System.out.println("Total words: " + words.size());

        BSTMap<String, Integer> map = new BSTMap<>();
        for (String word : words) {
            if (map.contains(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }

        System.out.println("Total different words: " + map.size());
        System.out.println("Frequency of PRIDE: " + map.get("pride"));
        System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));


        System.out.println();
    }
}
