package com.redis.example1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpRepo extends CrudRepository<SimpModel, String> {
}
