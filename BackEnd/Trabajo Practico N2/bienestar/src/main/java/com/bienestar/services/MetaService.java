package com.bienestar.services;

import com.bienestar.models.Meta;
import com.bienestar.repositories.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    public Meta crearMeta(Meta meta) {
        return metaRepository.save(meta);
    }

    public List<Meta> obtenerMetas() {
        return metaRepository.findAll();
    }

    public Optional<Meta> obtenerMetaPorId(String id) {
        return metaRepository.findById(id);
    }

    public void eliminarMeta(String id) {
        metaRepository.deleteById(id);
    }
}
