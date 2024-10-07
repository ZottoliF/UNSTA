package com.bienestar.controllers;

import com.bienestar.models.Miembro;
import com.bienestar.repositories.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembros")
public class MiembroController {

    @Autowired
    private MiembroRepository miembroRepository;

    @GetMapping
    public List<Miembro> getAllMiembros() {
        return miembroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Miembro> getMiembroById(@PathVariable String id) {
        return miembroRepository.findById(id)
                .map(miembro -> ResponseEntity.ok().body(miembro))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Miembro createMiembro(@RequestBody Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Miembro> updateMiembro(@PathVariable String id, @RequestBody Miembro miembroDetails) {
        return miembroRepository.findById(id)
                .map(miembro -> {
                    miembro.setNombre(miembroDetails.getNombre());
                    miembro.setEmail(miembroDetails.getEmail());
                    return ResponseEntity.ok(miembroRepository.save(miembro));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMiembro(@PathVariable String id) {
        return miembroRepository.findById(id)
                .map(miembro -> {
                    miembroRepository.delete(miembro);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
