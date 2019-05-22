package com.crud.redis.redis_config;

import com.crud.redis.SimpModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, SimpModel> redisTemplate(){
        RedisTemplate<String, SimpModel> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(jedisConnectionFactory());

        return redisTemplate;
    }

}
