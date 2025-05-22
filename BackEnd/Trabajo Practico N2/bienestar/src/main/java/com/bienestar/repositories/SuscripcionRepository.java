package com.bienestar.repositories;

import com.bienestar.models.Suscripcion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuscripcionRepository extends MongoRepository<Suscripcion, String> {
    List<Suscripcion> findByIdMiembro(String idMiembro);
}
