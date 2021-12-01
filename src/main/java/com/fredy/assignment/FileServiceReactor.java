package com.fredy.assignment;

import com.fredy.Util;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileServiceReactor {



    public static void main(String[] args) {

        write("file3.txt", "This is file 3").subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        read("file3.txt").subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        delete("file3.txt").subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }


    //Supplier
    private static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> FileServiceUtil.readFile(fileName));
    }

    private static Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> FileServiceUtil.writeFile(fileName, content));
    }

    private static Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> FileServiceUtil.deleteFile(fileName));
    }

}
