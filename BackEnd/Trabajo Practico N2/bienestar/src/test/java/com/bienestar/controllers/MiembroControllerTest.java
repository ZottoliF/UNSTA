package com.bienestar.controllers;

import com.bienestar.models.Miembro;
import com.bienestar.services.MiembroService;
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
import java.util.Arrays;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@WebMvcTest(MiembroController.class)
public class MiembroControllerTest {

    @Mock
    private MiembroService miembroService;

    @InjectMocks
    private MiembroController miembroController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(miembroController).build();
    }

    @Test
    public void testGetAllMiembros() throws Exception {
        Miembro miembro1 = new Miembro("Facundo", "Facundo@mail.com", "Meditacion");
        Miembro miembro2 = new Miembro("Maria", "Maria@mail.com", "Yoga");

        when(miembroService.obtenerMiembros()).thenReturn(Arrays.asList(miembro1, miembro2));

        mockMvc.perform(get("/miembros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", is("Facundo")))
                .andExpect(jsonPath("$[1].email", is("Maria@mail.com")));
    }
}
