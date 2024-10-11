package com.aprendizaje.services;

import com.aprendizaje.models.Evaluacion;
import com.aprendizaje.repositories.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<Evaluacion> obtenerTodasLasEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    public Optional<Evaluacion> obtenerEvaluacionPorId(String idEvaluacion) {
        return evaluacionRepository.findById(idEvaluacion);
    }

    public Evaluacion crearEvaluacion(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    public Evaluacion actualizarEvaluacion(String idEvaluacion, Evaluacion evaluacionActualizada) {
        return evaluacionRepository.findById(idEvaluacion).map(evaluacion -> {
            evaluacion.setTipoEvaluacion(evaluacionActualizada.getTipoEvaluacion());
            evaluacion.setPreguntas(evaluacionActualizada.getPreguntas());
            evaluacion.setResultado(evaluacionActualizada.getResultado());
            return evaluacionRepository.save(evaluacion);
        }).orElse(null); 
    }

    public void eliminarEvaluacion(String idEvaluacion) {
        evaluacionRepository.deleteById(idEvaluacion);
    }
}