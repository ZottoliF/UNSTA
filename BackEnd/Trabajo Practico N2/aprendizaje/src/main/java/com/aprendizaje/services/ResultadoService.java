package com.aprendizaje.services;

import com.aprendizaje.models.Resultado;
import com.aprendizaje.repositories.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoService {

    @Autowired
    private ResultadoRepository resultadoRepository;

    public List<Resultado> obtenerTodosLosResultados() {
        return resultadoRepository.findAll();
    }

    public Optional<Resultado> obtenerResultadoPorId(String id) {
        return resultadoRepository.findById(id);
    }

    public Resultado crearResultado(Resultado resultado) {
        return resultadoRepository.save(resultado);
    }

    public Resultado actualizarResultado(String id, Resultado resultadoActualizado) {
        if (resultadoRepository.existsById(id)) {
            resultadoActualizado.setIdResultado(id);
            return resultadoRepository.save(resultadoActualizado);
        }
        return null;
    }

    public void eliminarResultado(String id) {
        resultadoRepository.deleteById(id);
    }
}
