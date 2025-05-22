package com.bienestar.services;

import com.bienestar.models.Servicio;
import com.bienestar.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public Servicio crearServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public List<Servicio> obtenerServicios() {
        return servicioRepository.findAll();
    }

    public Optional<Servicio> obtenerServicioPorId(String id) {
        return servicioRepository.findById(id);
    }

    public void eliminarServicio(String id) {
        servicioRepository.deleteById(id);
    }
}
