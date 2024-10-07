package com.bienestar.services;

import com.bienestar.models.Progreso;
import com.bienestar.repositories.ProgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgresoService {

    @Autowired
    private ProgresoRepository progresoRepository;

    public List<Progreso> findAll() {
        return progresoRepository.findAll();
    }

    public Progreso findById(String id) {
        return progresoRepository.findById(id).orElse(null);
    }

    public Progreso save(Progreso progreso) {
        return progresoRepository.save(progreso);
    }

    public Progreso update(String id, Progreso progresoDetails) {
        Progreso progreso = findById(id);
        if (progreso != null) {
            progreso.setIdActividad(progresoDetails.getIdActividad());
            progreso.setFecha(progresoDetails.getFecha());
            return progresoRepository.save(progreso);
        }
        return null;
    }

    public void delete(String id) {
        progresoRepository.deleteById(id);
    }
}
