package com.bienestar.repositories;

import com.bienestar.models.Instalacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalacionRepository extends MongoRepository<Instalacion, String> {
}
