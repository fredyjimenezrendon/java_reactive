package com.fredy.javareactive;

import com.fredy.Util;
import reactor.core.publisher.Mono;

public class Supplier {

    public static void main(String[] args) {
        getName();
        getName()
                .subscribe(Util.onNext());
        getName();

    }

    //My bussiness logic
    private static Mono<String> getName() {
        System.out.println("entered get name method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating Name");
            Util.sleepSeconds(3);
            return Util.getFaker().name().fullName();
        }).map(String::toUpperCase);

        //Build de pipeline is different from executing the pipeline
    }
}
