package com.bienestar.services;

import com.bienestar.models.Miembro;
import com.bienestar.repositories.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiembroService {

    @Autowired
    private MiembroRepository miembroRepository;

    public Miembro crearMiembro(Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    public List<Miembro> obtenerMiembros() {
        return miembroRepository.findAll();
    }

    public Optional<Miembro> obtenerMiembroPorId(String id) {
        return miembroRepository.findById(id);
    }

    public void eliminarMiembro(String id) {
        miembroRepository.deleteById(id);
    }
}
