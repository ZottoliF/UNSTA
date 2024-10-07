package com.bienestar.repositories;

import com.bienestar.models.Recomendacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecomendacionRepository extends MongoRepository<Recomendacion, String> {
}
