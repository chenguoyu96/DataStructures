package org.chenguoyu.datastructure.set;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.apache.commons.io.IOUtils;
import org.chenguoyu.datastructure.FileOperation;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author chenguoyu
 * @date 2018-12-04
 * @program DataStructures
 */
public class BSTSetTest {
    @Test
    public void main() throws IOException {

        System.out.println("Pride and Prejudice");
        System.out.println(ClassPath.SYSTEM_CLASS_PATH.toString());
        List<String> words1 = FileOperation.readFile("pride-and-prejudice.txt");
        System.out.println("Total words: " + words1.size());
        BSTSet<String> set1 = new BSTSet<>();
        for (String word : words1)
            set1.add(word);
        System.out.println("Total different words: " + set1.size());

        System.out.println();

        System.out.println("A Tale of Two Cities");
        List<String> words2 = FileOperation.readFile("a-tale-of-two-cities.txt");
        System.out.println("Total words: " + words2.size());
        BSTSet<String> set2 = new BSTSet<>();
        for (String word : words2)
            set2.add(word);
        System.out.println("Total different words: " + set2.size());

    }

    @Test
    public void getClassPath() {
        String path = BSTSetTest.class.getResource("/").toString();
        System.out.println(path);
    }
}
