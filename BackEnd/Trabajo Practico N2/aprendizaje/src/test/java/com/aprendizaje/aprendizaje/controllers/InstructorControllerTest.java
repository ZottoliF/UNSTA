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

import com.aprendizaje.models.Instructor;
import com.aprendizaje.services.InstructorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(InstructorController.class)
public class InstructorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private InstructorService instructorService;

    @InjectMocks
    private InstructorController instructorController;

    private Instructor instructor1;
    private Instructor instructor2;

    @BeforeEach
    public void setUp() {
        instructor1 = new Instructor("Ana", "ana@example.com");
        instructor2 = new Instructor("Luis", "luis@example.com");
    }

    @Test
    public void testGetAllInstructores() throws Exception {
        List<Instructor> instructores = Arrays.asList(instructor1, instructor2);

        when(instructorService.obtenerTodosLosInstructores()).thenReturn(instructores);

        mockMvc.perform(get("/api/instructores")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Ana"))
                .andExpect(jsonPath("$[1].correo").value("luis@example.com"));
    }

    @Test
    public void testCreateInstructor() throws Exception {
        Instructor nuevoInstructor = new Instructor("Pedro", "pedro@example.com");

        when(instructorService.crearInstructor(any(Instructor.class))).thenReturn(nuevoInstructor);

        mockMvc.perform(post("/api/instructores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(nuevoInstructor)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Pedro"));
    }
}
