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

import com.aprendizaje.models.Estudiante;
import com.aprendizaje.services.EstudianteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EstudianteController.class)
public class EstudianteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EstudianteService estudianteService;

    @InjectMocks
    private EstudianteController estudianteController;

    private Estudiante estudiante1;
    private Estudiante estudiante2;

    @BeforeEach
    public void setUp() {
        estudiante1 = new Estudiante("Juan", "juan@example.com");
        estudiante2 = new Estudiante("Maria", "maria@example.com");
    }

    @Test
    public void testGetAllEstudiantes() throws Exception {
        List<Estudiante> estudiantes = Arrays.asList(estudiante1, estudiante2);

        when(estudianteService.obtenerTodosLosEstudiantes()).thenReturn(estudiantes);

        mockMvc.perform(get("/api/estudiantes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Juan"))
                .andExpect(jsonPath("$[1].correo").value("maria@example.com"));
    }

    @Test
    public void testCreateEstudiante() throws Exception {
        Estudiante nuevoEstudiante = new Estudiante("Carlos", "carlos@example.com");

        when(estudianteService.crearEstudiante(any(Estudiante.class))).thenReturn(nuevoEstudiante);

        mockMvc.perform(post("/api/estudiantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(nuevoEstudiante)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Carlos"));
    }
}
