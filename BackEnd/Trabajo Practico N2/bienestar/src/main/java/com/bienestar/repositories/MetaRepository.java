package com.bienestar.repositories;

import com.bienestar.models.Meta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends MongoRepository<Meta, String> {
}
