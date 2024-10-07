package com.bienestar.services;

import com.bienestar.models.Recomendacion;
import com.bienestar.repositories.RecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecomendacionService {

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    public Recomendacion crearRecomendacion(Recomendacion recomendacion) {
        return recomendacionRepository.save(recomendacion);
    }

    public List<Recomendacion> obtenerRecomendaciones() {
        return recomendacionRepository.findAll();
    }

    public Optional<Recomendacion> obtenerRecomendacionPorId(String id) {
        return recomendacionRepository.findById(id);
    }

    public void eliminarRecomendacion(String id) {
        recomendacionRepository.deleteById(id);
    }
}
