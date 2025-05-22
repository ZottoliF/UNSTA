package com.aprendizaje.services;

import com.aprendizaje.models.Pregunta;
import com.aprendizaje.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    public List<Pregunta> obtenerTodasLasPreguntas() {
        return preguntaRepository.findAll();
    }

    public Optional<Pregunta> obtenerPreguntaPorId(String idPregunta) {
        return preguntaRepository.findById(idPregunta);
    }

    public Pregunta crearPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public Pregunta actualizarPregunta(String idPregunta, Pregunta preguntaActualizada) {
        return preguntaRepository.findById(idPregunta).map(pregunta -> {
            pregunta.setTexto(preguntaActualizada.getTexto());
            pregunta.setOpciones(preguntaActualizada.getOpciones());
            return preguntaRepository.save(pregunta);
        }).orElse(null);
    }

    public void eliminarPregunta(String idPregunta) {
        preguntaRepository.deleteById(idPregunta);
    }
}
