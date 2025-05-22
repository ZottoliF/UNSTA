package com.bienestar.services;

import com.bienestar.models.Suscripcion;
import com.bienestar.repositories.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    public Suscripcion crearSuscripcion(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    public List<Suscripcion> obtenerSuscripciones() {
        return suscripcionRepository.findAll();
    }

    public Optional<Suscripcion> obtenerSuscripcionPorId(String id) {
        return suscripcionRepository.findById(id);
    }

    public void eliminarSuscripcion(String id) {
        suscripcionRepository.deleteById(id);
    }

    public List<Suscripcion> buscarSuscripcionesPorMiembro(String idMiembro) {
        return suscripcionRepository.findByIdMiembro(idMiembro);
    }
}
