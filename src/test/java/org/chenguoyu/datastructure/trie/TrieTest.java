package org.chenguoyu.datastructure.trie;

import org.chenguoyu.datastructure.FileOperation;
import org.chenguoyu.datastructure.set.BSTSet;

import java.util.List;

/**
 * @author chenguoyu
 * @date 2018-12-07
 * @program DataStructures
 */
public class TrieTest {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        List<String> words = FileOperation.readFile("pride-and-prejudice.txt");

        long startTime = System.nanoTime();

        BSTSet<String> set = new BSTSet<>();
        for (String word : words)
            set.add(word);

        for (String word : words)
            set.contain(word);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        System.out.println("Total different words: " + set.size());
        System.out.println("BSTSet: " + time + " s");

        // ---

        startTime = System.nanoTime();

        Trie trie = new Trie();
        for (String word : words)
            trie.add(word);

        for (String word : words)
            trie.contain(word);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;

        System.out.println("Total different words: " + trie.size());
        System.out.println("Trie: " + time + " s");
    }
}

