package com.example.cappedcollections;


import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ExampleRepo extends ReactiveCrudRepository<Example, String> {



    @Tailable
    Flux<Example> findWithTailableCursorBy();
}
