package com.aprendizaje.aprendizaje.controllers;

import com.aprendizaje.models.Curso;
import com.aprendizaje.services.CursoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CursoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CursoService cursoService;

    @InjectMocks
    private CursoController cursoController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(cursoController).build();
    }

    @Test
    void obtenerTodosLosCursos() throws Exception {
        Curso curso = new Curso("1", "Java Básico", "Descripción curso", null);
        when(cursoService.obtenerTodosLosCursos()).thenReturn(Arrays.asList(curso));

        mockMvc.perform(get("/api/cursos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].idCurso").value("1"))
                .andExpect(jsonPath("$[0].nombre").value("Java Básico"));
    }

    @Test
    void obtenerCursoPorId() throws Exception {
        Curso curso = new Curso("1", "Java Básico", "Descripción curso", null);
        when(cursoService.obtenerCursoPorId("1")).thenReturn(Optional.of(curso));

        mockMvc.perform(get("/api/cursos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCurso").value("1"))
                .andExpect(jsonPath("$.nombre").value("Java Básico"));
    }

    @Test
    void crearCurso() throws Exception {
        Curso curso = new Curso("1", "Java Básico", "Descripción curso", null);
        when(cursoService.crearCurso(any(Curso.class))).thenReturn(curso);

        mockMvc.perform(post("/api/cursos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Java Básico\", \"descripcion\":\"Descripción curso\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idCurso").value("1"))
                .andExpect(jsonPath("$.nombre").value("Java Básico"));
    }

    @Test
    void actualizarCurso() throws Exception {
        Curso curso = new Curso("1", "Java Básico", "Descripción curso", null);
        when(cursoService.actualizarCurso("1", any(Curso.class))).thenReturn(curso);

        mockMvc.perform(put("/api/cursos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Java Avanzado\", \"descripcion\":\"Nuevo curso\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Java Básico"));
    }

    @Test
    void eliminarCurso() throws Exception {
        doNothing().when(cursoService).eliminarCurso("1");

        mockMvc.perform(delete("/api/cursos/1"))
                .andExpect(status().isNoContent());
    }
}
