package com.ceiba.asesoria.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.asesoria.comando.ComandoAsesoria;
import com.ceiba.asesoria.servicio.testdatabuilder.ComandoAsesoriaTestDataBuilder;
import com.ceiba.usuario.controlador.ComandoControladorUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorUsuario.class)
public class ComandoControladorAsesoriaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception {
        ComandoAsesoria asesoria = new ComandoAsesoriaTestDataBuilder().build();
        mocMvc.perform(post("/asesorias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(asesoria)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @Test
    public void actualizar() throws Exception {
        Long id = 1L;
        ComandoAsesoria asesoria = new ComandoAsesoriaTestDataBuilder().build();

        mocMvc.perform(put("/asesorias/{1}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(asesoria)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        Long id = 2L;

        mocMvc.perform(delete("/asesorias/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
