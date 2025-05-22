package com.aprendizaje.controllers;

import com.aprendizaje.models.Resultado;
import com.aprendizaje.services.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @GetMapping
public ResponseEntity<List<Resultado>> obtenerTodosLosResultados() {
    List<Resultado> resultados = resultadoService.obtenerTodosLosResultados();
    return new ResponseEntity<>(resultados, HttpStatus.OK);
}


    @GetMapping("/{id}")
    public ResponseEntity<Resultado> obtenerResultadoPorId(@PathVariable String id) {
        Optional<Resultado> resultado = resultadoService.obtenerResultadoPorId(id);
        return resultado.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Resultado> crearResultado(@RequestBody Resultado resultado) {
        Resultado nuevoResultado = resultadoService.crearResultado(resultado);
        return new ResponseEntity<>(nuevoResultado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resultado> actualizarResultado(@PathVariable String id, @RequestBody Resultado resultadoActualizado) {
        Resultado resultado = resultadoService.actualizarResultado(id, resultadoActualizado);
        if (resultado != null) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarResultado(@PathVariable String id) {
        resultadoService.eliminarResultado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
