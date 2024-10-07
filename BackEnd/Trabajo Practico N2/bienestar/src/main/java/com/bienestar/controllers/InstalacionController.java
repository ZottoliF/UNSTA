package com.bienestar.controllers;

import com.bienestar.models.Instalacion;
import com.bienestar.repositories.InstalacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instalaciones")
public class InstalacionController {

    @Autowired
    private InstalacionRepository instalacionRepository;

    @GetMapping
    public List<Instalacion> getAllInstalaciones() {
        return instalacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instalacion> getInstalacionById(@PathVariable String id) {
        return instalacionRepository.findById(id)
                .map(instalacion -> ResponseEntity.ok().body(instalacion))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Instalacion createInstalacion(@RequestBody Instalacion instalacion) {
        return instalacionRepository.save(instalacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instalacion> updateInstalacion(@PathVariable String id, @RequestBody Instalacion instalacionDetails) {
        return instalacionRepository.findById(id)
                .map(instalacion -> {
                    instalacion.setNombre(instalacionDetails.getNombre());
                    instalacion.setCapacidad(instalacionDetails.getCapacidad());
                    // Actualiza otros campos según sea necesario
                    return ResponseEntity.ok(instalacionRepository.save(instalacion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstalacion(@PathVariable String id) {
        return instalacionRepository.findById(id)
                .map(instalacion -> {
                    instalacionRepository.delete(instalacion);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
