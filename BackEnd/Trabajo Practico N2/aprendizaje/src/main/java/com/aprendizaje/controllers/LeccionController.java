package com.aprendizaje.controllers;

import com.aprendizaje.models.Leccion;
import com.aprendizaje.services.LeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lecciones")
public class LeccionController {

    @Autowired
    private LeccionService leccionService;

    @GetMapping
    public ResponseEntity<List<Leccion>> obtenerTodasLasLecciones() {
        List<Leccion> lecciones = leccionService.obtenerTodasLasLecciones();
        return new ResponseEntity<>(lecciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leccion> obtenerLeccionPorId(@PathVariable String id) {
        Optional<Leccion> leccion = leccionService.obtenerLeccionPorId(id);
        return leccion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Leccion> crearLeccion(@RequestBody Leccion leccion) {
        Leccion nuevaLeccion = leccionService.crearLeccion(leccion);
        return new ResponseEntity<>(nuevaLeccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leccion> actualizarLeccion(@PathVariable String id, @RequestBody Leccion leccionActualizada) {
        Leccion leccion = leccionService.actualizarLeccion(id, leccionActualizada);
        if (leccion != null) {
            return new ResponseEntity<>(leccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLeccion(@PathVariable String id) {
        leccionService.eliminarLeccion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
