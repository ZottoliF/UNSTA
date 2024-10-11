package com.aprendizaje.controllers;

import com.aprendizaje.models.Progreso;
import com.aprendizaje.services.ProgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/progresos")
public class ProgresoController {

    @Autowired
    private ProgresoService progresoService;

    @GetMapping
    public ResponseEntity<List<Progreso>> obtenerTodosLosProgresos() {
        List<Progreso> progresos = progresoService.obtenerTodosLosProgresos();
        return new ResponseEntity<>(progresos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progreso> obtenerProgresoPorId(@PathVariable String id) {
        Optional<Progreso> progreso = progresoService.obtenerProgresoPorId(id);
        return progreso.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Progreso> crearProgreso(@RequestBody Progreso progreso) {
        Progreso nuevoProgreso = progresoService.crearProgreso(progreso);
        return new ResponseEntity<>(nuevoProgreso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Progreso> actualizarProgreso(@PathVariable String id, @RequestBody Progreso progresoActualizado) {
        Progreso progreso = progresoService.actualizarProgreso(id, progresoActualizado);
        if (progreso != null) {
            return new ResponseEntity<>(progreso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProgreso(@PathVariable String id) {
        progresoService.eliminarProgreso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
