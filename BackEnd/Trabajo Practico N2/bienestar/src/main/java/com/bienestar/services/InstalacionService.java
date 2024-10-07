package com.bienestar.services;

import com.bienestar.models.Instalacion;
import com.bienestar.repositories.InstalacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstalacionService {

    @Autowired
    private InstalacionRepository instalacionRepository;

    public List<Instalacion> findAll() {
        return instalacionRepository.findAll();
    }

    public Instalacion findById(String id) {
        return instalacionRepository.findById(id).orElse(null);
    }

    public Instalacion save(Instalacion instalacion) {
        return instalacionRepository.save(instalacion);
    }

    public Instalacion update(String id, Instalacion instalacionDetails) {
        Instalacion instalacion = findById(id);
        if (instalacion != null) {
            instalacion.setNombre(instalacionDetails.getNombre());
            instalacion.setCapacidad(instalacionDetails.getCapacidad());
            return instalacionRepository.save(instalacion);
        }
        return null;
    }

    public void delete(String id) {
        instalacionRepository.deleteById(id);
    }
}
