package com.bienestar.controllers;

import com.bienestar.models.Meta;
import com.bienestar.repositories.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    @Autowired
    private MetaRepository metaRepository;

    @GetMapping
    public List<Meta> getAllMetas() {
        return metaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meta> getMetaById(@PathVariable String id) {
        return metaRepository.findById(id)
                .map(meta -> ResponseEntity.ok().body(meta))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Meta createMeta(@RequestBody Meta meta) {
        return metaRepository.save(meta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meta> updateMeta(@PathVariable String id, @RequestBody Meta metaDetails) {
        return metaRepository.findById(id)
                .map(meta -> {
                    meta.setDescripcion(metaDetails.getDescripcion());
                    meta.setFechaObjetivo(metaDetails.getFechaObjetivo());
                    return ResponseEntity.ok(metaRepository.save(meta));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeta(@PathVariable String id) {
        return metaRepository.findById(id)
                .map(meta -> {
                    metaRepository.delete(meta);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
