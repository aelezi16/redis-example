package com.redis.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis")
public class SimpController {

    private SimpRepo simpRepo;

    @Autowired
    public SimpController(SimpRepo simpRepo){
        this.simpRepo = simpRepo;
    }

    @PostMapping
    public void post(@RequestBody SimpModel simpModel){
        simpRepo.save(simpModel);
    }

    @GetMapping("/{id}")
    public SimpModel get(@PathVariable String id){
        return simpRepo.findById(id).get();
    }

}
