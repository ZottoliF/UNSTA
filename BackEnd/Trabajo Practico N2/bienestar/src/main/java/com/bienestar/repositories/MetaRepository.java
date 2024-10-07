package com.bienestar.repositories;

import com.bienestar.models.Meta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetaRepository extends MongoRepository<Meta, String> {
}
