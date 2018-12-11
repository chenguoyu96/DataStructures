package org.chenguoyu.datastructure;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenguoyu
 * @date 2018-12-04
 * @program DataStructures
 */
public class FileOperation {
    public static List<String> readFile(String filePath) {
        try {
            String str = IOUtils.toString(FileOperation.class.getResourceAsStream("/" + filePath));
            List<String> words = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(str,"\\A\t\n\r\f");
            while (st.hasMoreElements()){
                words.add(st.nextToken());
            }
            return words;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
