package com.aprendizaje.controllers;

import com.aprendizaje.models.Estudiante;
import com.aprendizaje.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodosLosEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable String id) {
        Optional<Estudiante> estudiante = estudianteService.obtenerEstudiantePorId(id);
        return estudiante.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                         .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.crearEstudiante(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable String id, @RequestBody Estudiante estudianteActualizado) {
        Estudiante estudiante = estudianteService.actualizarEstudiante(id, estudianteActualizado);
        if (estudiante != null) {
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable String id) {
        estudianteService.eliminarEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}