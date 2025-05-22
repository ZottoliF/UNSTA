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

import com.aprendizaje.models.Resultado;
import com.aprendizaje.services.ResultadoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ResultadoController.class)
public class ResultadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ResultadoService resultadoService;

    @InjectMocks
    private ResultadoController resultadoController;

    private Resultado resultado1;
    private Resultado resultado2;

    @BeforeEach
    public void setUp() {
        resultado1 = new Resultado("Juan", "Examen Final", 85);
        resultado2 = new Resultado("Maria", "Examen Parcial", 90);
    }

    @Test
    public void testGetAllResultados() throws Exception {
        List<Resultado> resultados = Arrays.asList(resultado1, resultado2);

        when(resultadoService.obtenerTodosLosResultados()).thenReturn(resultados);

        mockMvc.perform(get("/api/resultados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].estudiante").value("Juan"))
                .andExpect(jsonPath("$[1].puntaje").value(90));
    }

    @Test
    public void testCreateResultado() throws Exception {
        Resultado nuevoResultado = new Resultado("Carlos", "Examen Recuperatorio", 75);

        when(resultadoService.crearResultado(any(Resultado.class))).thenReturn(nuevoResultado);

        mockMvc.perform(post("/api/resultados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(nuevoResultado)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.estudiante").value("Carlos"));
    }
}
