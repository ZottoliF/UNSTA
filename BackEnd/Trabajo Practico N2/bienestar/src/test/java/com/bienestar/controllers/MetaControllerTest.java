package com.bienestar.controllers;

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

import com.bienestar.models.Meta;
import com.bienestar.services.MetaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MetaController.class)
public class MetaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MetaService metaService;

    @InjectMocks
    private MetaController metaController;

    private Meta meta1;
    private Meta meta2;
    
    @BeforeEach
    public void setUp() {
        meta1 = new Meta("Perder peso", "En progreso", "Ejercicio diario");
        meta2 = new Meta("Ganar músculo", "Completado", "Entrenamiento de fuerza");
    }

    @Test
    public void testGetAllMetas() throws Exception {
        List<Meta> metas = Arrays.asList(meta1, meta2);

        when(metaService.obtenerMetas()).thenReturn(metas);

        mockMvc.perform(get("/metas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].metas").value("Perder peso"))
                .andExpect(jsonPath("$[1].progreso").value("Completado"));
    }
    
    @Test
    public void testCreateMeta() throws Exception {
        Meta newMeta = new Meta("Mejorar resistencia", "En progreso", "Correr 5 km diario");

        when(metaService.crearMeta(any(Meta.class))).thenReturn(newMeta);

        mockMvc.perform(post("/metas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newMeta)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.metas").value("Mejorar resistencia"));
    }
}
