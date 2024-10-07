package com.bienestar.controllers;

import com.bienestar.models.Suscripcion;
import com.bienestar.services.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suscripciones")
public class SuscripcionController {

    @Autowired
    private SuscripcionService suscripcionService;

    @PostMapping
    public ResponseEntity<Suscripcion> crearSuscripcion(@RequestBody Suscripcion suscripcion) {
        Suscripcion nuevaSuscripcion = suscripcionService.crearSuscripcion(suscripcion);
        return ResponseEntity.ok(nuevaSuscripcion);
    }

    @GetMapping
    public ResponseEntity<List<Suscripcion>> obtenerSuscripciones() {
        List<Suscripcion> suscripciones = suscripcionService.obtenerSuscripciones();
        return ResponseEntity.ok(suscripciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suscripcion> obtenerSuscripcionPorId(@PathVariable String id) {
        return suscripcionService.obtenerSuscripcionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSuscripcion(@PathVariable String id) {
        suscripcionService.eliminarSuscripcion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/miembro/{idMiembro}")
    public ResponseEntity<List<Suscripcion>> buscarSuscripcionesPorMiembro(@PathVariable String idMiembro) {
        List<Suscripcion> suscripciones = suscripcionService.buscarSuscripcionesPorMiembro(idMiembro);
        return ResponseEntity.ok(suscripciones);
    }
}
