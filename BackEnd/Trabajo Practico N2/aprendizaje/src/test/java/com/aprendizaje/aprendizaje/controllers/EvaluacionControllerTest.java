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

import com.aprendizaje.models.Evaluacion;
import com.aprendizaje.services.EvaluacionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EvaluacionController.class)
public class EvaluacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EvaluacionService evaluacionService;

    @InjectMocks
    private EvaluacionController evaluacionController;

    private Evaluacion evaluacion1;
    private Evaluacion evaluacion2;

    @BeforeEach
    public void setUp() {
        evaluacion1 = new Evaluacion("Examen Final", 85);
        evaluacion2 = new Evaluacion("Examen Parcial", 90);
    }

    @Test
    public void testGetAllEvaluaciones() throws Exception {
        List<Evaluacion> evaluaciones = Arrays.asList(evaluacion1, evaluacion2);

        when(evaluacionService.obtenerTodasLasEvaluaciones()).thenReturn(evaluaciones);

        mockMvc.perform(get("/api/evaluaciones")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Examen Final"))
                .andExpect(jsonPath("$[1].puntaje").value(90));
    }

    @Test
    public void testCreateEvaluacion() throws Exception {
        Evaluacion nuevaEvaluacion = new Evaluacion("Examen Recuperatorio", 80);

        when(evaluacionService.crearEvaluacion(any(Evaluacion.class))).thenReturn(nuevaEvaluacion);

        mockMvc.perform(post("/api/evaluaciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(nuevaEvaluacion)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Examen Recuperatorio"));
    }
}
