package com.bienestar.controllers;

import com.bienestar.models.Suscripcion;
import com.bienestar.repositories.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suscripciones")
public class SuscripcionController {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @GetMapping
    public List<Suscripcion> getAllSuscripciones() {
        return suscripcionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suscripcion> getSuscripcionById(@PathVariable String id) {
        return suscripcionRepository.findById(id)
                .map(suscripcion -> ResponseEntity.ok().body(suscripcion))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Suscripcion createSuscripcion(@RequestBody Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suscripcion> updateSuscripcion(@PathVariable String id, @RequestBody Suscripcion suscripcionDetails) {
        return suscripcionRepository.findById(id)
                .map(suscripcion -> {
                    suscripcion.setTipo(suscripcionDetails.getTipo());
                    suscripcion.setCosto(suscripcionDetails.getCosto());
                    return ResponseEntity.ok(suscripcionRepository.save(suscripcion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuscripcion(@PathVariable String id) {
        return suscripcionRepository.findById(id)
                .map(suscripcion -> {
                    suscripcionRepository.delete(suscripcion);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
