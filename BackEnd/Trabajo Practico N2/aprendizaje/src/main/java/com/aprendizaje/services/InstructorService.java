package com.aprendizaje.services;

import com.aprendizaje.models.Instructor;
import com.aprendizaje.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> obtenerTodosLosInstructores() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> obtenerInstructorPorId(String idInstructor) {
        return instructorRepository.findById(idInstructor);
    }

    public Instructor crearInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor actualizarInstructor(String idInstructor, Instructor instructorActualizado) {
        return instructorRepository.findById(idInstructor).map(instructor -> {
            instructor.setEspecialidad(instructorActualizado.getEspecialidad());
            instructor.setCursosCreados(instructorActualizado.getCursosCreados());
            return instructorRepository.save(instructor);
        }).orElse(null); 
    }

    public void eliminarInstructor(String idInstructor) {
        instructorRepository.deleteById(idInstructor);
    }
}
