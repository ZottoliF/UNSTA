package com.bienestar.controllers;

import com.bienestar.models.Progreso;
import com.bienestar.services.ProgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progresos")
public class ProgresoController {

    @Autowired
    private ProgresoService progresoService;

    @PostMapping
    public ResponseEntity<Progreso> crearProgreso(@RequestBody Progreso progreso) {
        Progreso nuevoProgreso = progresoService.crearProgreso(progreso);
        return ResponseEntity.ok(nuevoProgreso);
    }

    @GetMapping
    public ResponseEntity<List<Progreso>> obtenerProgresos() {
        List<Progreso> progresos = progresoService.obtenerProgresos();
        return ResponseEntity.ok(progresos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progreso> obtenerProgresoPorId(@PathVariable String id) {
        return progresoService.obtenerProgresoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProgreso(@PathVariable String id) {
        progresoService.eliminarProgreso(id);
        return ResponseEntity.noContent().build();
    }
}
