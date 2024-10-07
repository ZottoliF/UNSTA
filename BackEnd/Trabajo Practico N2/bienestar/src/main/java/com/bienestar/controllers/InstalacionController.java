package com.bienestar.controllers;

import com.bienestar.models.Instalacion;
import com.bienestar.services.InstalacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instalaciones")
public class InstalacionController {

    @Autowired
    private InstalacionService instalacionService;

    @PostMapping
    public ResponseEntity<Instalacion> crearInstalacion(@RequestBody Instalacion instalacion) {
        Instalacion nuevaInstalacion = instalacionService.crearInstalacion(instalacion);
        return ResponseEntity.ok(nuevaInstalacion);
    }

    @GetMapping
    public ResponseEntity<List<Instalacion>> obtenerInstalaciones() {
        List<Instalacion> instalaciones = instalacionService.obtenerInstalaciones();
        return ResponseEntity.ok(instalaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instalacion> obtenerInstalacionPorId(@PathVariable String id) {
        return instalacionService.obtenerInstalacionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInstalacion(@PathVariable String id) {
        instalacionService.eliminarInstalacion(id);
        return ResponseEntity.noContent().build();
    }
}
