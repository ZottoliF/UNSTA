package com.aprendizaje.aprendizaje.controllers;

import com.aprendizaje.models.Evaluacion;
import com.aprendizaje.services.EvaluacionService;
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

public class EvaluacionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EvaluacionService evaluacionService;

    @InjectMocks
    private EvaluacionController evaluacionController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(evaluacionController).build();
    }

    @Test
    void obtenerTodasLasEvaluaciones() throws Exception {
        Evaluacion evaluacion = new Evaluacion("1", 90, null);
        when(evaluacionService.obtenerTodasLasEvaluaciones()).thenReturn(Arrays.asList(evaluacion));

        mockMvc.perform(get("/api/evaluaciones"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].idEvaluacion").value("1"))
                .andExpect(jsonPath("$[0].calificacion").value(90));
    }

    @Test
    void obtenerEvaluacionPorId() throws Exception {
        Evaluacion evaluacion = new Evaluacion("1", 90, null);
        when(evaluacionService.obtenerEvaluacionPorId("1")).thenReturn(Optional.of(evaluacion));

        mockMvc.perform(get("/api/evaluaciones/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEvaluacion").value("1"))
                .andExpect(jsonPath("$.calificacion").value(90));
    }

    @Test
    void crearEvaluacion() throws Exception {
        Evaluacion evaluacion = new Evaluacion("1", 90, null);
        when(evaluacionService.crearEvaluacion(any(Evaluacion.class))).thenReturn(evaluacion);

        mockMvc.perform(post("/api/evaluaciones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"calificacion\":90}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idEvaluacion").value("1"))
                .andExpect(jsonPath("$.calificacion").value(90));
    }

    @Test
    void actualizarEvaluacion() throws Exception {
        Evaluacion evaluacion = new Evaluacion("1", 90, null);
        when(evaluacionService.actualizarEvaluacion("1", any(Evaluacion.class))).thenReturn(evaluacion);

        mockMvc.perform(put("/api/evaluaciones/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"calificacion\":95}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.calificacion").value(90));
    }

    @Test
    void eliminarEvaluacion() throws Exception {
        doNothing().when(evaluacionService).eliminarEvaluacion("1");

        mockMvc.perform(delete("/api/evaluaciones/1"))
                .andExpect(status().isNoContent());
    }
}
