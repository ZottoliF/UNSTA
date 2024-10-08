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

import com.bienestar.models.Instalacion;
import com.bienestar.services.InstalacionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(InstalacionController.class)
public class InstalacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private InstalacionService instalacionService;

    @InjectMocks
    private InstalacionController instalacionController;

    private Instalacion instalacion1;
    private Instalacion instalacion2;

    @BeforeEach
    public void setUp() {
        instalacion1 = new Instalacion("Gimnasio", 50);
        instalacion2 = new Instalacion("Piscina", 30);
    }

    @Test
    public void testGetAllInstalaciones() throws Exception {
        List<Instalacion> instalaciones = Arrays.asList(instalacion1, instalacion2);

        when(instalacionService.obtenerInstalaciones()).thenReturn(instalaciones);

        mockMvc.perform(get("/instalaciones")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Gimnasio"))
                .andExpect(jsonPath("$[1].capacidad").value(30));
    }
    
    @Test
    public void testCreateInstalacion() throws Exception {
        Instalacion newInstalacion = new Instalacion("Sala de Yoga", 20);

        when(instalacionService.crearInstalacion(any(Instalacion.class))).thenReturn(newInstalacion);

        mockMvc.perform(post("/instalaciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newInstalacion)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Sala de Yoga"));
    }
}
