package com.bienestar.services;

import com.bienestar.models.Pago;
import com.bienestar.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    public Pago findById(String id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago update(String id, Pago pagoDetails) {
        Pago pago = findById(id);
        if (pago != null) {
            pago.setFecha(pagoDetails.getFecha());
            pago.setMonto(pagoDetails.getMonto());
            return pagoRepository.save(pago);
        }
        return null;
    }

    public void delete(String id) {
        pagoRepository.deleteById(id);
    }
}
