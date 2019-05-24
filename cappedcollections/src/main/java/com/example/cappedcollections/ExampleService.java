package com.example.cappedcollections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Service
public class ExampleService {

    private ReactiveMongoTemplate reactiveMongoTemplate;
    private ExampleRepo exampleRepo;

    @Autowired
    public ExampleService(
            ReactiveMongoTemplate reactiveMongoTemplate,
            ExampleRepo exampleRepo
    ){
        this.exampleRepo = exampleRepo;
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }


    @PostConstruct
    void configure(){
        reactiveMongoTemplate.dropCollection("Example")
                .then(
                        reactiveMongoTemplate.createCollection(
                                "Example", CollectionOptions.empty().capped().size(4096).maxDocuments(10000)
                        )
                ).subscribe();
    }

    public Mono<Example> save(Example example){
        return this.exampleRepo.save(example);
    }

    public Flux<Example> getAllByTailing(){
        return this.exampleRepo.findWithTailableCursorBy();
    }

}
