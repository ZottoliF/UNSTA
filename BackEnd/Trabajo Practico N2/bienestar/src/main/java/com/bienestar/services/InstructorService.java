package com.bienestar.services;

import com.bienestar.models.Instructor;
import com.bienestar.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    public Instructor findById(String id) {
        return instructorRepository.findById(id).orElse(null);
    }

    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor update(String id, Instructor instructorDetails) {
        Instructor instructor = findById(id);
        if (instructor != null) {
            instructor.setNombre(instructorDetails.getNombre());
            instructor.setEspecialidad(instructorDetails.getEspecialidad());
            // Actualiza otros campos según sea necesario
            return instructorRepository.save(instructor);
        }
        return null;
    }

    public void delete(String id) {
        instructorRepository.deleteById(id);
    }
}
