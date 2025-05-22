package com.aprendizaje.controllers;

import com.aprendizaje.models.Pregunta;
import com.aprendizaje.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @GetMapping
    public ResponseEntity<List<Pregunta>> obtenerTodasLasPreguntas() {
        List<Pregunta> preguntas = preguntaService.obtenerTodasLasPreguntas();
        return new ResponseEntity<>(preguntas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> obtenerPreguntaPorId(@PathVariable String id) {
        Optional<Pregunta> pregunta = preguntaService.obtenerPreguntaPorId(id);
        return pregunta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Pregunta> crearPregunta(@RequestBody Pregunta pregunta) {
        Pregunta nuevaPregunta = preguntaService.crearPregunta(pregunta);
        return new ResponseEntity<>(nuevaPregunta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pregunta> actualizarPregunta(@PathVariable String id, @RequestBody Pregunta preguntaActualizada) {
        Pregunta pregunta = preguntaService.actualizarPregunta(id, preguntaActualizada);
        if (pregunta != null) {
            return new ResponseEntity<>(pregunta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPregunta(@PathVariable String id) {
        preguntaService.eliminarPregunta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
