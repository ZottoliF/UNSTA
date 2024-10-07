package com.bienestar.controllers;

import com.bienestar.models.Progreso;
import com.bienestar.repositories.ProgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progresos")
public class ProgresoController {

    @Autowired
    private ProgresoRepository progresoRepository;

    @GetMapping
    public List<Progreso> getAllProgresos() {
        return progresoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progreso> getProgresoById(@PathVariable String id) {
        return progresoRepository.findById(id)
                .map(progreso -> ResponseEntity.ok().body(progreso))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Progreso createProgreso(@RequestBody Progreso progreso) {
        return progresoRepository.save(progreso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Progreso> updateProgreso(@PathVariable String id, @RequestBody Progreso progresoDetails) {
        return progresoRepository.findById(id)
                .map(progreso -> {
                    progreso.setIdMiembro(progresoDetails.getIdMiembro());
                    progreso.setIdActividad(progresoDetails.getIdActividad());
                    progreso.setFecha(progresoDetails.getFecha());
                    return ResponseEntity.ok(progresoRepository.save(progreso));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgreso(@PathVariable String id) {
        return progresoRepository.findById(id)
                .map(progreso -> {
                    progresoRepository.delete(progreso);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
