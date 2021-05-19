package com.ceiba.asesoria.servicio;

import com.ceiba.asesoria.puerto.repositorio.RepositorioAsesoria;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ServicioEliminarAsesoriaTest {

    @InjectMocks
    private ServicioEliminarAsesoria servicioEliminarAsesoria;

    @Mock
    private RepositorioAsesoria repositorioAsesoria;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarValido() {
        Long id = 1L;

        doNothing().when(repositorioAsesoria).eliminar(anyLong());
        servicioEliminarAsesoria.ejecutar(id);

        verify(repositorioAsesoria, times(1)).eliminar(anyLong());
    }
}
