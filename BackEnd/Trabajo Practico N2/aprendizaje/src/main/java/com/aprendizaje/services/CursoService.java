package com.aprendizaje.services;

import com.aprendizaje.models.Curso;
import com.aprendizaje.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerCursoPorId(String idCurso) {
        return cursoRepository.findById(idCurso);
    }

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso actualizarCurso(String idCurso, Curso cursoActualizado) {
        return cursoRepository.findById(idCurso).map(curso -> {
            curso.setNombre(cursoActualizado.getNombre());
            curso.setDescripcion(cursoActualizado.getDescripcion());
            curso.setInstructor(cursoActualizado.getInstructor());
            curso.setModulos(cursoActualizado.getModulos());
            return cursoRepository.save(curso);
        }).orElse(null); 
    }

    public void eliminarCurso(String idCurso) {
        cursoRepository.deleteById(idCurso);
    }
}
