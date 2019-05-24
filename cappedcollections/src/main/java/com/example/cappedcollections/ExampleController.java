package com.example.cappedcollections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/mongodb")
public class ExampleController {


    private final ExampleService exampleService;

    @Autowired
    public ExampleController(
            ExampleService exampleService
    ){
        this.exampleService = exampleService;
    }


    @PostMapping
    public Mono<Example> post(@RequestBody Example example){
       return exampleService.save(example);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Example> getByTailing(){
        return this.exampleService.getAllByTailing().delayElements(Duration.ofSeconds(1));
    }
}
