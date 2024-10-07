package com.bienestar.services;

import com.bienestar.models.Reserva;
import com.bienestar.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva findById(String id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva update(String id, Reserva reservaDetails) {
        Reserva reserva = findById(id);
        if (reserva != null) {
            reserva.setIdActividad(reservaDetails.getIdActividad());
            reserva.setIdMiembro(reservaDetails.getIdMiembro());
            reserva.setFecha(reservaDetails.getFecha());
            return reservaRepository.save(reserva);
        }
        return null;
    }

    public void delete(String id) {
        reservaRepository.deleteById(id);
    }
}
