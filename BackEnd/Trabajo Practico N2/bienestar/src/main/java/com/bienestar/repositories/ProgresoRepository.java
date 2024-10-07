package com.bienestar.repositories;

import com.bienestar.models.Progreso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgresoRepository extends MongoRepository<Progreso, String> {
}
