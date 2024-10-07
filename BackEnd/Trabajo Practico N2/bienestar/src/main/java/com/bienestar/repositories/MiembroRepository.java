package com.bienestar.repositories;

import com.bienestar.models.Miembro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiembroRepository extends MongoRepository<Miembro, String> {
}
