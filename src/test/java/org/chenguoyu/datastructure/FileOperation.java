package org.chenguoyu.datastructure;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
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
            List<String> words = Stream.of(str.split(" "))
                    .peek(String::toLowerCase).collect(Collectors.toList());
            return words;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
