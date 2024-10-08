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

import com.bienestar.models.Instructor;
import com.bienestar.services.InstructorService;
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
        instructor1 = new Instructor("Yoga", "Meditación");
        instructor2 = new Instructor("Crossfit", "Fuerza");
    }

    @Test
    public void testGetAllInstructores() throws Exception {
        List<Instructor> instructores = Arrays.asList(instructor1, instructor2);

        when(instructorService.obtenerInstructores()).thenReturn(instructores);

        mockMvc.perform(get("/instructores")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cursosCreados").value("Yoga"))
                .andExpect(jsonPath("$[1].especialidad").value("Fuerza"));
    }
    
    @Test
    public void testCreateInstructor() throws Exception {
        Instructor newInstructor = new Instructor("Pilates", "Postura");

        when(instructorService.crearInstructor(any(Instructor.class))).thenReturn(newInstructor);

        mockMvc.perform(post("/instructores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newInstructor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cursosCreados").value("Pilates"));
    }
}
