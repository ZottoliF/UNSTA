package com.bienestar.services;

import com.bienestar.models.Recomendacion;
import com.bienestar.repositories.RecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacionService {

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    public List<Recomendacion> findAll() {
        return recomendacionRepository.findAll();
    }

    public Recomendacion findById(String id) {
        return recomendacionRepository.findById(id).orElse(null);
    }

    public Recomendacion save(Recomendacion recomendacion) {
        return recomendacionRepository.save(recomendacion);
    }

    public Recomendacion update(String id, Recomendacion recomendacionDetails) {
        Recomendacion recomendacion = findById(id);
        if (recomendacion != null) {
            recomendacion.setMensaje(recomendacionDetails.getMensaje());
            return recomendacionRepository.save(recomendacion);
        }
        return null;
    }

    public void delete(String id) {
        recomendacionRepository.deleteById(id);
    }
}
