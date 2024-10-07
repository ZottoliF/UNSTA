package com.bienestar.controllers;

import com.bienestar.models.Recomendacion;
import com.bienestar.repositories.RecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recomendaciones")
public class RecomendacionController {

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    @GetMapping
    public List<Recomendacion> getAllRecomendaciones() {
        return recomendacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recomendacion> getRecomendacionById(@PathVariable String id) {
        return recomendacionRepository.findById(id)
                .map(recomendacion -> ResponseEntity.ok().body(recomendacion))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Recomendacion createRecomendacion(@RequestBody Recomendacion recomendacion) {
        return recomendacionRepository.save(recomendacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recomendacion> updateRecomendacion(@PathVariable String id, @RequestBody Recomendacion recomendacionDetails) {
        return recomendacionRepository.findById(id)
                .map(recomendacion -> {
                    recomendacion.setMensaje(recomendacionDetails.getMensaje());
                    return ResponseEntity.ok(recomendacionRepository.save(recomendacion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecomendacion(@PathVariable String id) {
        return recomendacionRepository.findById(id)
                .map(recomendacion -> {
                    recomendacionRepository.delete(recomendacion);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
