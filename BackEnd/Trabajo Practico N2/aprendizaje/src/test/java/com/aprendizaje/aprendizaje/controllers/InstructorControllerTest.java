package com.aprendizaje.aprendizaje.controllers;

import com.aprendizaje.models.Instructor;
import com.aprendizaje.services.InstructorService;
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

public class InstructorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private InstructorService instructorService;

    @InjectMocks
    private InstructorController instructorController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(instructorController).build();
    }

    @Test
    void obtenerTodosLosInstructores() throws Exception {
        Instructor instructor = new Instructor("1", "Ana", "ana@mail.com");
        when(instructorService.obtenerTodosLosInstructores()).thenReturn(Arrays.asList(instructor));

        mockMvc.perform(get("/api/instructores"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].idInstructor").value("1"))
                .andExpect(jsonPath("$[0].nombre").value("Ana"));
    }

    @Test
    void obtenerInstructorPorId() throws Exception {
        Instructor instructor = new Instructor("1", "Ana", "ana@mail.com");
        when(instructorService.obtenerInstructorPorId("1")).thenReturn(Optional.of(instructor));

        mockMvc.perform(get("/api/instructores/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idInstructor").value("1"))
                .andExpect(jsonPath("$.nombre").value("Ana"));
    }

    @Test
    void crearInstructor() throws Exception {
        Instructor instructor = new Instructor("1", "Ana", "ana@mail.com");
        when(instructorService.crearInstructor(any(Instructor.class))).thenReturn(instructor);

        mockMvc.perform(post("/api/instructores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Ana\", \"mail\":\"ana@mail.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idInstructor").value("1"))
                .andExpect(jsonPath("$.nombre").value("Ana"));
    }

    @Test
    void actualizarInstructor() throws Exception {
        Instructor instructor = new Instructor("1", "Ana", "ana@mail.com");
        when(instructorService.actualizarInstructor("1", any(Instructor.class))).thenReturn(instructor);

        mockMvc.perform(put("/api/instructores/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Luis\", \"mail\":\"luis@mail.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Ana"));
    }

    @Test
    void eliminarInstructor() throws Exception {
        doNothing().when(instructorService).eliminarInstructor("1");

        mockMvc.perform(delete("/api/instructores/1"))
                .andExpect(status().isNoContent());
    }
}
