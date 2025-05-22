package com.bienestar.controllers;

import com.bienestar.models.Reserva;
import com.bienestar.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaService.crearReserva(reserva);
        return ResponseEntity.ok(nuevaReserva);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> obtenerReservas() {
        List<Reserva> reservas = reservaService.obtenerReservas();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable String id) {
        return reservaService.obtenerReservaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable String id) {
        reservaService.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/miembro/{idMiembro}")
    public ResponseEntity<List<Reserva>> buscarReservasPorMiembro(@PathVariable String idMiembro) {
        List<Reserva> reservas = reservaService.buscarReservasPorMiembro(idMiembro);
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/instructor/{idInstructor}")
    public ResponseEntity<List<Reserva>> buscarReservasPorInstructor(@PathVariable String idInstructor) {
        List<Reserva> reservas = reservaService.buscarReservasPorInstructor(idInstructor);
        return ResponseEntity.ok(reservas);
    }
}
