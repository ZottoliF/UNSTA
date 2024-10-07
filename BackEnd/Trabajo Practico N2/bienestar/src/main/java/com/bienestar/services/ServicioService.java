package com.bienestar.services;

import com.bienestar.models.Servicio;
import com.bienestar.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    public Servicio findById(String id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Servicio update(String id, Servicio servicioDetails) {
        Servicio servicio = findById(id);
        if (servicio != null) {
            servicio.setNombre(servicioDetails.getNombre());
            servicio.setDescripcion(servicioDetails.getDescripcion());
            return servicioRepository.save(servicio);
        }
        return null;
    }

    public void delete(String id) {
        servicioRepository.deleteById(id);
    }
}
