package com.redis.example2;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis")
public class SimpleController {


    private final SimpleRepository simpleRepository;
    private  RedisTemplate<String, String> redisTemplate;
    private Gson jsonCoverter;

    @Autowired
    public SimpleController(SimpleRepository simpleRepository,
                            RedisTemplate<String, String> redisTemplate,
                            Gson jsonConverter
                            ){
        this.simpleRepository = simpleRepository;

        this.redisTemplate = redisTemplate;

        this.jsonCoverter =jsonConverter;

        hashOps = redisTemplate.opsForHash();
    }

    HashOperations hashOps;


    @PostMapping
    public void post(@RequestBody SimpleModel simpleModel){
            simpleRepository.save(simpleModel);
    }

    @GetMapping("/{id}")
    public SimpleModel get(@PathVariable String id){
        return simpleRepository.findById(id).get();
    }


    //REDIS TEMPLATE
    @PostMapping("/v2")
    public void post2(@RequestBody SModel simpleModel){
        hashOps.put("SM", simpleModel.getId(), jsonCoverter.toJson(simpleModel));
    }

    @GetMapping("/v2/{id}")
    public SModel get2(@PathVariable String id){
        return (SModel)jsonCoverter.fromJson((String)hashOps.get("SM", id), SModel.class);
    }
}
