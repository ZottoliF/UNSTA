package com.aprendizaje.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.aprendizaje.models.Curso;
import com.aprendizaje.services.CursoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CursoController.class)
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CursoService cursoService;

    @InjectMocks
    private CursoController cursoController;

    private Curso curso1;
    private Curso curso2;

    @BeforeEach
    public void setUp() {
        curso1 = new Curso("Curso Java", "Introducción Java");
        curso2 = new Curso("Curso Spring Boot", "Proyecto Spring Boot");
    }

    @Test
    public void testGetAllCursos() throws Exception {
        List<Curso> cursos = Arrays.asList(curso1, curso2);

        when(cursoService.obtenerTodosLosCursos()).thenReturn(cursos);

        mockMvc.perform(get("/api/cursos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Curso Java"))
                .andExpect(jsonPath("$[1].descripcion").value("Proyecto Spring Boot"));
    }

    @Test
    public void testCreateCurso() throws Exception {
        Curso newCurso = new Curso("Curso MongoDB", "Introduccion MongoDB");

        when(cursoService.crearCurso(any(Curso.class))).thenReturn(newCurso);

        mockMvc.perform(post("/api/cursos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newCurso)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Curso MongoDB"))
                .andExpect(jsonPath("$.descripcion").value("Introduccion MongoDB"));
    }
}
