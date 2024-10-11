package com.aprendizaje.controllers;

import com.aprendizaje.models.Instructor;
import com.aprendizaje.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructores")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public ResponseEntity<List<Instructor>> obtenerTodosLosInstructores() {
        List<Instructor> instructores = instructorService.obtenerTodosLosInstructores();
        return new ResponseEntity<>(instructores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> obtenerInstructorPorId(@PathVariable String id) {
        Optional<Instructor> instructor = instructorService.obtenerInstructorPorId(id);
        return instructor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                         .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Instructor> crearInstructor(@RequestBody Instructor instructor) {
        Instructor nuevoInstructor = instructorService.crearInstructor(instructor);
        return new ResponseEntity<>(nuevoInstructor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> actualizarInstructor(@PathVariable String id, @RequestBody Instructor instructorActualizado) {
        Instructor instructor = instructorService.actualizarInstructor(id, instructorActualizado);
        if (instructor != null) {
            return new ResponseEntity<>(instructor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInstructor(@PathVariable String id) {
        instructorService.eliminarInstructor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
