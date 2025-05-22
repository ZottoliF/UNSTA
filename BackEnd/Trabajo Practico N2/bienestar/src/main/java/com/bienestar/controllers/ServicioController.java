package com.bienestar.controllers;

import com.bienestar.models.Servicio;
import com.bienestar.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
        Servicio nuevoServicio = servicioService.crearServicio(servicio);
        return ResponseEntity.ok(nuevoServicio);
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> obtenerServicios() {
        List<Servicio> servicios = servicioService.obtenerServicios();
        return ResponseEntity.ok(servicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> obtenerServicioPorId(@PathVariable String id) {
        return servicioService.obtenerServicioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable String id) {
        servicioService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }
}
