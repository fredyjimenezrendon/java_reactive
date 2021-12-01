package com.fredy;

import reactor.core.publisher.Mono;

public class MonoSubscribe {

    public static void main(String[] args) {

        Mono<Integer> mono = Mono.just("hello")
                .map(String::length)
                .map(l -> l / 0);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }

}
