package com.bienestar.services;

import com.bienestar.models.Meta;
import com.bienestar.repositories.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    public List<Meta> findAll() {
        return metaRepository.findAll();
    }

    public Meta findById(String id) {
        return metaRepository.findById(id).orElse(null);
    }

    public Meta save(Meta meta) {
        return metaRepository.save(meta);
    }

    public Meta update(String id, Meta metaDetails) {
        Meta meta = findById(id);
        if (meta != null) {
            meta.setDescripcion(metaDetails.getDescripcion());
            meta.setFechaObjetivo(metaDetails.getFechaObjetivo());
            return metaRepository.save(meta);
        }
        return null;
    }

    public void delete(String id) {
        metaRepository.deleteById(id);
    }
}
