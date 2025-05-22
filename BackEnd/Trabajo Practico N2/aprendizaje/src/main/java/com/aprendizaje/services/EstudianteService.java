package com.aprendizaje.services;

import com.aprendizaje.models.Estudiante;
import com.aprendizaje.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> obtenerEstudiantePorId(String idEstudiante) {
        return estudianteRepository.findById(idEstudiante);
    }

    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante actualizarEstudiante(String idEstudiante, Estudiante estudianteActualizado) {
        return estudianteRepository.findById(idEstudiante).map(estudiante -> {
            estudiante.setNivelConocimiento(estudianteActualizado.getNivelConocimiento());
            estudiante.setPreferenciaAprendizaje(estudianteActualizado.getPreferenciaAprendizaje());
            estudiante.setProgreso(estudianteActualizado.getProgreso());
            return estudianteRepository.save(estudiante);
        }).orElse(null); 
    }

    public void eliminarEstudiante(String idEstudiante) {
        estudianteRepository.deleteById(idEstudiante);
    }
}