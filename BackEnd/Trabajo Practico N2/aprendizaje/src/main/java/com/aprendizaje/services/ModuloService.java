package com.aprendizaje.services;

import com.aprendizaje.models.Modulo;
import com.aprendizaje.repositories.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public List<Modulo> obtenerTodosLosModulos() {
        return moduloRepository.findAll();
    }

    public Optional<Modulo> obtenerModuloPorId(String idModulo) {
        return moduloRepository.findById(idModulo);
    }

    public Modulo crearModulo(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    public Modulo actualizarModulo(String idModulo, Modulo moduloActualizado) {
        return moduloRepository.findById(idModulo).map(modulo -> {
            modulo.setNombre(moduloActualizado.getNombre());
            modulo.setDescripcion(moduloActualizado.getDescripcion());
            modulo.setLecciones(moduloActualizado.getLecciones());
            return moduloRepository.save(modulo);
        }).orElse(null);
    }

    public void eliminarModulo(String idModulo) {
        moduloRepository.deleteById(idModulo);
    }
}
