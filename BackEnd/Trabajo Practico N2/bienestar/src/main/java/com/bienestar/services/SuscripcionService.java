package com.bienestar.services;

import com.bienestar.models.Suscripcion;
import com.bienestar.repositories.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    public List<Suscripcion> findAll() {
        return suscripcionRepository.findAll();
    }

    public Suscripcion findById(String id) {
        return suscripcionRepository.findById(id).orElse(null);
    }

    public Suscripcion save(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    public Suscripcion update(String id, Suscripcion suscripcionDetails) {
        Suscripcion suscripcion = findById(id);
        if (suscripcion != null) {
            suscripcion.setTipo(suscripcionDetails.getTipo());
            suscripcion.setCosto(suscripcionDetails.getCosto());
            return suscripcionRepository.save(suscripcion);
        }
        return null;
    }

    public void delete(String id) {
        suscripcionRepository.deleteById(id);
    }
}
