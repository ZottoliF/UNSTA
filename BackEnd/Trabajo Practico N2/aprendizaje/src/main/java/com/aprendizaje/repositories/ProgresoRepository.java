package com.aprendizaje.repositories;

import com.aprendizaje.models.Progreso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgresoRepository extends MongoRepository<Progreso, String> {
}