package com.bienestar.controllers;

import com.bienestar.models.Meta;
import com.bienestar.services.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @PostMapping
    public ResponseEntity<Meta> crearMeta(@RequestBody Meta meta) {
        Meta nuevaMeta = metaService.crearMeta(meta);
        return ResponseEntity.ok(nuevaMeta);
    }

    @GetMapping
    public ResponseEntity<List<Meta>> obtenerMetas() {
        List<Meta> metas = metaService.obtenerMetas();
        return ResponseEntity.ok(metas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meta> obtenerMetaPorId(@PathVariable String id) {
        return metaService.obtenerMetaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMeta(@PathVariable String id) {
        metaService.eliminarMeta(id);
        return ResponseEntity.noContent().build();
    }
}
