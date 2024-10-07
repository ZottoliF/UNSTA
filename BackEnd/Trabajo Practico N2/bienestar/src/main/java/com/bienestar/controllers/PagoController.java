package com.bienestar.controllers;

import com.bienestar.models.Pago;
import com.bienestar.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;

    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable String id) {
        return pagoRepository.findById(id)
                .map(pago -> ResponseEntity.ok().body(pago))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pago createPago(@RequestBody Pago pago) {
        return pagoRepository.save(pago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable String id, @RequestBody Pago pagoDetails) {
        return pagoRepository.findById(id)
                .map(pago -> {
                    pago.setMonto(pagoDetails.getMonto());
                    pago.setFecha(pagoDetails.getFecha());
                    return ResponseEntity.ok(pagoRepository.save(pago));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable String id) {
        return pagoRepository.findById(id)
                .map(pago -> {
                    pagoRepository.delete(pago);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
