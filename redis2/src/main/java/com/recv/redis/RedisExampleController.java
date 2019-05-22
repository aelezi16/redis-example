package com.crud.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/api")
public class RedisExampleController {

    private RedisTemplate<String, SimpModel> redisTemplate;

    @Autowired
    public RedisExampleController(RedisTemplate<String, SimpModel> redisTemplate){
        this.redisTemplate = redisTemplate;

        hashOps = redisTemplate.opsForHash();
    }

    private HashOperations hashOps;

    @PostMapping
    public void post(@RequestBody SimpModel simpModel){
        hashOps.put("Head", simpModel.getKey(), simpModel);
        SimpModel gotten = (SimpModel)hashOps.get("Head", simpModel.getKey());

        System.out.println(gotten.getValue());
    }
}
