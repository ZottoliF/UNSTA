package com.bienestar.controllers;

import com.bienestar.models.Instructor;
import com.bienestar.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructores")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping
    public List<Instructor> getAllInstructores() {
        return instructorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable String id) {
        return instructorRepository.findById(id)
                .map(instructor -> ResponseEntity.ok().body(instructor))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable String id, @RequestBody Instructor instructorDetails) {
        return instructorRepository.findById(id)
                .map(instructor -> {
                    instructor.setNombre(instructorDetails.getNombre());
                    instructor.setEspecialidad(instructorDetails.getEspecialidad());
                    // Actualiza otros campos según sea necesario
                    return ResponseEntity.ok(instructorRepository.save(instructor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable String id) {
        return instructorRepository.findById(id)
                .map(instructor -> {
                    instructorRepository.delete(instructor);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
