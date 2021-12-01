package com.fredy;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {

    public static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> System.out.println("received: " + o);
    }

    public static Consumer<Throwable> onError() {
        return e -> System.out.println("ERROR: " + e.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("Completed");
    }

    public static Faker getFaker() {
        return FAKER;
    }

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds* 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}