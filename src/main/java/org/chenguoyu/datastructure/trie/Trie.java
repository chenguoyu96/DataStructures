package org.chenguoyu.datastructure.trie;

import java.util.TreeMap;

/**
 * @author chenguoyu
 * @date 2018-12-06
 * @program DataStructures
 */
public class Trie {
    private class Node {
        boolean isWord;
        TreeMap<Character, Node> next;

        Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * 添加单词
     *
     * @param word
     */
    public void add(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next.get(c) == null) {
                curr.next.put(c, new Node());
            }
            curr = curr.next.get(c);
        }
        if (!curr.isWord) {
            curr.isWord = true;
            size++;
        }
    }

    /**
     * trie是否包含单词word
     *
     * @param word
     * @return
     */
    public boolean contain(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next.get(c) == null) {
                return false;
            }
            curr = curr.next.get(c);
        }
        return curr.isWord;
    }

    /**
     * trie中是否包含以prefix为前缀的单词
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.next.get(c) == null) {
                return false;
            }
            curr = curr.next.get(c);
        }
        return true;
    }
}
