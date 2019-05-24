package com.redis.example1;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("SM")
@AllArgsConstructor
@NoArgsConstructor
public class SimpModel {

    @Id
    private String id;
    private String value;
}
