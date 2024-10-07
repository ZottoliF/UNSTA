package com.bienestar.services;

import com.bienestar.models.Miembro;
import com.bienestar.repositories.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembroService {

    @Autowired
    private MiembroRepository miembroRepository;

    public List<Miembro> findAll() {
        return miembroRepository.findAll();
    }

    public Miembro findById(String id) {
        return miembroRepository.findById(id).orElse(null);
    }

    public Miembro save(Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    public Miembro update(String id, Miembro miembroDetails) {
        Miembro miembro = findById(id);
        if (miembro != null) {
            miembro.setNombre(miembroDetails.getNombre());
            miembro.setEmail(miembroDetails.getEmail());
            return miembroRepository.save(miembro);
        }
        return null;
    }

    public void delete(String id) {
        miembroRepository.deleteById(id);
    }
}
