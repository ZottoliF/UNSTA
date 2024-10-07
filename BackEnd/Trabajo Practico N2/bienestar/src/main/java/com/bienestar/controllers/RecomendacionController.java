package com.bienestar.controllers;

import com.bienestar.models.Recomendacion;
import com.bienestar.services.RecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recomendaciones")
public class RecomendacionController {

    @Autowired
    private RecomendacionService recomendacionService;

    @PostMapping
    public ResponseEntity<Recomendacion> crearRecomendacion(@RequestBody Recomendacion recomendacion) {
        Recomendacion nuevaRecomendacion = recomendacionService.crearRecomendacion(recomendacion);
        return ResponseEntity.ok(nuevaRecomendacion);
    }

    @GetMapping
    public ResponseEntity<List<Recomendacion>> obtenerRecomendaciones() {
        List<Recomendacion> recomendaciones = recomendacionService.obtenerRecomendaciones();
        return ResponseEntity.ok(recomendaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recomendacion> obtenerRecomendacionPorId(@PathVariable String id) {
        return recomendacionService.obtenerRecomendacionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRecomendacion(@PathVariable String id) {
        recomendacionService.eliminarRecomendacion(id);
        return ResponseEntity.noContent().build();
    }
}
