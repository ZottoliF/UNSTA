package com.bienestar.repositories;

import com.bienestar.models.Servicio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends MongoRepository<Servicio, String> {
}
