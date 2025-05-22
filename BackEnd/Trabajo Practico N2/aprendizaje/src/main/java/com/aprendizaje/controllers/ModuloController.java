package com.aprendizaje.controllers;

import com.aprendizaje.models.Modulo;
import com.aprendizaje.services.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    @GetMapping
    public ResponseEntity<List<Modulo>> obtenerTodosLosModulos() {
        List<Modulo> modulos = moduloService.obtenerTodosLosModulos();
        return new ResponseEntity<>(modulos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modulo> obtenerModuloPorId(@PathVariable String id) {
        Optional<Modulo> modulo = moduloService.obtenerModuloPorId(id);
        return modulo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Modulo> crearModulo(@RequestBody Modulo modulo) {
        Modulo nuevoModulo = moduloService.crearModulo(modulo);
        return new ResponseEntity<>(nuevoModulo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modulo> actualizarModulo(@PathVariable String id, @RequestBody Modulo moduloActualizado) {
        Modulo modulo = moduloService.actualizarModulo(id, moduloActualizado);
        if (modulo != null) {
            return new ResponseEntity<>(modulo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarModulo(@PathVariable String id) {
        moduloService.eliminarModulo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
