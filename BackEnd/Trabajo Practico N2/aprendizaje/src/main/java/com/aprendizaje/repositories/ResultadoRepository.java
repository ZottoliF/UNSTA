package com.aprendizaje.repositories;

import com.aprendizaje.models.Resultado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultadoRepository extends MongoRepository<Resultado, String> {
}
