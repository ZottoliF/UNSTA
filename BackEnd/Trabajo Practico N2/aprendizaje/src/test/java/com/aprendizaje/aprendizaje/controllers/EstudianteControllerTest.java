package com.aprendizaje.aprendizaje.controllers;

import com.aprendizaje.models.Estudiante;
import com.aprendizaje.services.EstudianteService;
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

public class EstudianteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EstudianteService estudianteService;

    @InjectMocks
    private EstudianteController estudianteController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(estudianteController).build();
    }

    @Test
    void obtenerTodosLosEstudiantes() throws Exception {
        Estudiante estudiante = new Estudiante("1", "Juan", "juan@mail.com");
        when(estudianteService.obtenerTodosLosEstudiantes()).thenReturn(Arrays.asList(estudiante));

        mockMvc.perform(get("/api/estudiantes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].idEstudiante").value("1"))
                .andExpect(jsonPath("$[0].nombre").value("Juan"));
    }

    @Test
    void obtenerEstudiantePorId() throws Exception {
        Estudiante estudiante = new Estudiante("1", "Juan", "juan@mail.com");
        when(estudianteService.obtenerEstudiantePorId("1")).thenReturn(Optional.of(estudiante));

        mockMvc.perform(get("/api/estudiantes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEstudiante").value("1"))
                .andExpect(jsonPath("$.nombre").value("Juan"));
    }

    @Test
    void crearEstudiante() throws Exception {
        Estudiante estudiante = new Estudiante("1", "Juan", "juan@mail.com");
        when(estudianteService.crearEstudiante(any(Estudiante.class))).thenReturn(estudiante);

        mockMvc.perform(post("/api/estudiantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Juan\", \"mail\":\"juan@mail.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idEstudiante").value("1"))
                .andExpect(jsonPath("$.nombre").value("Juan"));
    }

    @Test
    void actualizarEstudiante() throws Exception {
        Estudiante estudiante = new Estudiante("1", "Juan", "juan@mail.com");
        when(estudianteService.actualizarEstudiante("1", any(Estudiante.class))).thenReturn(estudiante);

        mockMvc.perform(put("/api/estudiantes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Carlos\", \"mail\":\"carlos@mail.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Juan"));
    }

    @Test
    void eliminarEstudiante() throws Exception {
        doNothing().when(estudianteService).eliminarEstudiante("1");

        mockMvc.perform(delete("/api/estudiantes/1"))
                .andExpect(status().isNoContent());
    }
}
