package com.bienestar.repositories;

import com.bienestar.models.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagoRepository extends MongoRepository<Pago, String> {
}
