package com.redis.example2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleRepository extends CrudRepository<SimpleModel, String> {
}
