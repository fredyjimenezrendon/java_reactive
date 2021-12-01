package com.fredy.assignment;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FileService {

    public static void main(String[] args) {
        write("file3.txt", "this is file 3").accept(StringUtils.EMPTY);

        System.out.println(read("file3.txt").get());

         delete("file3.txt").accept(StringUtils.EMPTY);
    }

    private static Consumer write(String fileName, String content) {
        return o -> FileServiceUtil.writeFile(fileName, content);
    }

    private static Supplier<String> read(String fileName) {
        return () -> FileServiceUtil.readFile(fileName);
    }

    private static Consumer delete(String fileName) {
        return o -> FileServiceUtil.deleteFile(fileName);
    }

}
