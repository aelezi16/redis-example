package com.redis.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("SM")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SimpleModel {

    @Id
    private String id;
    private String value;
}
