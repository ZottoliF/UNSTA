package com.bienestar.controllers;

import com.bienestar.models.Pago;
import com.bienestar.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public ResponseEntity<Pago> crearPago(@RequestBody Pago pago) {
        Pago nuevoPago = pagoService.crearPago(pago);
        return ResponseEntity.ok(nuevoPago);
    }

    @GetMapping
    public ResponseEntity<List<Pago>> obtenerPagos() {
        List<Pago> pagos = pagoService.obtenerPagos();
        return ResponseEntity.ok(pagos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPagoPorId(@PathVariable String id) {
        return pagoService.obtenerPagoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable String id) {
        pagoService.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }
}
