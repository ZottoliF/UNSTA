package com.aprendizaje.repositories;

import com.aprendizaje.models.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
}