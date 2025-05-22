package com.bienestar.controllers;

import com.bienestar.models.Miembro;
import com.bienestar.services.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembros")
public class MiembroController {

    @Autowired
    private MiembroService miembroService;

    @PostMapping
    public ResponseEntity<Miembro> crearMiembro(@RequestBody Miembro miembro) {
        Miembro nuevoMiembro = miembroService.crearMiembro(miembro);
        return ResponseEntity.ok(nuevoMiembro);
    }

    @GetMapping
    public ResponseEntity<List<Miembro>> obtenerMiembros() {
        List<Miembro> miembros = miembroService.obtenerMiembros();
        return ResponseEntity.ok(miembros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Miembro> obtenerMiembroPorId(@PathVariable String id) {
        return miembroService.obtenerMiembroPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMiembro(@PathVariable String id) {
        miembroService.eliminarMiembro(id);
        return ResponseEntity.noContent().build();
    }
}
