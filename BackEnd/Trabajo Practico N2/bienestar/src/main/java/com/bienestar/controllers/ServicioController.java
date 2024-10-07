package com.bienestar.controllers;

import com.bienestar.models.Servicio;
import com.bienestar.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping
    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable String id) {
        return servicioRepository.findById(id)
                .map(servicio -> ResponseEntity.ok().body(servicio))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Servicio createServicio(@RequestBody Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> updateServicio(@PathVariable String id, @RequestBody Servicio servicioDetails) {
        return servicioRepository.findById(id)
                .map(servicio -> {
                    servicio.setNombre(servicioDetails.getNombre());
                    servicio.setDescripcion(servicioDetails.getDescripcion());
                    // Actualiza otros campos según sea necesario
                    return ResponseEntity.ok(servicioRepository.save(servicio));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicio(@PathVariable String id) {
        return servicioRepository.findById(id)
                .map(servicio -> {
                    servicioRepository.delete(servicio);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
