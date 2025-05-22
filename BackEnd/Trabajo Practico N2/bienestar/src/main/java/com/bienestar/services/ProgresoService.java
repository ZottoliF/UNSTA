package com.bienestar.services;

import com.bienestar.models.Progreso;
import com.bienestar.repositories.ProgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgresoService {

    @Autowired
    private ProgresoRepository progresoRepository;

    public Progreso crearProgreso(Progreso progreso) {
        return progresoRepository.save(progreso);
    }

    public List<Progreso> obtenerProgresos() {
        return progresoRepository.findAll();
    }

    public Optional<Progreso> obtenerProgresoPorId(String id) {
        return progresoRepository.findById(id);
    }

    public void eliminarProgreso(String id) {
        progresoRepository.deleteById(id);
    }
}
