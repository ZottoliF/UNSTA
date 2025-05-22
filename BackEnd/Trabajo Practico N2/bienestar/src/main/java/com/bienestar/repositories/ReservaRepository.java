package com.bienestar.repositories;

import com.bienestar.models.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {
    List<Reserva> findByIdMiembro(String idMiembro);
    List<Reserva> findByIdInstructor(String idInstructor);
}
