package com.aprendizaje.controllers;

import com.aprendizaje.models.Evaluacion;
import com.aprendizaje.services.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public ResponseEntity<List<Evaluacion>> obtenerTodasLasEvaluaciones() {
        List<Evaluacion> evaluaciones = evaluacionService.obtenerTodasLasEvaluaciones();
        return new ResponseEntity<>(evaluaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> obtenerEvaluacionPorId(@PathVariable String id) {
        Optional<Evaluacion> evaluacion = evaluacionService.obtenerEvaluacionPorId(id);
        return evaluacion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                         .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        Evaluacion nuevaEvaluacion = evaluacionService.crearEvaluacion(evaluacion);
        return new ResponseEntity<>(nuevaEvaluacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> actualizarEvaluacion(@PathVariable String id, @RequestBody Evaluacion evaluacionActualizada) {
        Evaluacion evaluacion = evaluacionService.actualizarEvaluacion(id, evaluacionActualizada);
        if (evaluacion != null) {
            return new ResponseEntity<>(evaluacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvaluacion(@PathVariable String id) {
        evaluacionService.eliminarEvaluacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
