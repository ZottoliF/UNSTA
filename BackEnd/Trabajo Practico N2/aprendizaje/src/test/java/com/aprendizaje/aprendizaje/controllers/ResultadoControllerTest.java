package com.aprendizaje.aprendizaje.controllers;

import com.aprendizaje.models.Resultado;
import com.aprendizaje.services.ResultadoService;
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

public class ResultadoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ResultadoService resultadoService;

    @InjectMocks
    private ResultadoController resultadoController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(resultadoController).build();
    }

    @Test
    void obtenerTodosLosResultados() throws Exception {
        Resultado resultado = new Resultado("1", "Exitoso", 100);
        when(resultadoService.obtenerTodosLosResultados()).thenReturn(Arrays.asList(resultado));

        mockMvc.perform(get("/api/resultados"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].idResultado").value("1"))
                .andExpect(jsonPath("$[0].estado").value("Exitoso"));
    }

    @Test
    void obtenerResultadoPorId() throws Exception {
        Resultado resultado = new Resultado("1", "Exitoso", 100);
        when(resultadoService.obtenerResultadoPorId("1")).thenReturn(Optional.of(resultado));

        mockMvc.perform(get("/api/resultados/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idResultado").value("1"))
                .andExpect(jsonPath("$.estado").value("Exitoso"));
    }

    @Test
    void crearResultado() throws Exception {
        Resultado resultado = new Resultado("1", "Exitoso", 100);
        when(resultadoService.crearResultado(any(Resultado.class))).thenReturn(resultado);

        mockMvc.perform(post("/api/resultados")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"estado\":\"Exitoso\", \"puntaje\":100}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idResultado").value("1"))
                .andExpect(jsonPath("$.estado").value("Exitoso"));
    }

    @Test
    void actualizarResultado() throws Exception {
        Resultado resultado = new Resultado("1", "Exitoso", 100);
        when(resultadoService.actualizarResultado("1", any(Resultado.class))).thenReturn(resultado);

        mockMvc.perform(put("/api/resultados/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"estado\":\"Fallido\", \"puntaje\":50}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estado").value("Exitoso"));
    }

    @Test
    void eliminarResultado() throws Exception {
        doNothing().when(resultadoService).eliminarResultado("1");

        mockMvc.perform(delete("/api/resultados/1"))
                .andExpect(status().isNoContent());
    }
}
