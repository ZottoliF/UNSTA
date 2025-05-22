package com.bienestar.controllers;

import com.bienestar.models.Reserva;
import com.bienestar.services.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.time.LocalDate;
import java.util.Arrays;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@WebMvcTest(ReservaController.class)
public class ReservaControllerTest {

    @Mock
    private ReservaService reservaService;

    @InjectMocks
    private ReservaController reservaController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(reservaController).build();
    }

    @Test
    public void testGetAllReservas() throws Exception {
        Reserva reserva1 = new Reserva("miembro1", "instructor1", "servicio1", "instalacion1", "pendiente", LocalDate.now());
        Reserva reserva2 = new Reserva("miembro2", "instructor2", "servicio2", "instalacion2", "confirmada", LocalDate.now());

        when(reservaService.obtenerReservas()).thenReturn(Arrays.asList(reserva1, reserva2));

        mockMvc.perform(get("/reservas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idMiembro", is("miembro1")))
                .andExpect(jsonPath("$[1].estado", is("confirmada")));
    }
}
