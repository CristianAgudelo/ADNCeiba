package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class ServicioActualizarUsuarioTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        when(repositorioUsuario.existeExcluyendoId(anyLong(), anyString())).thenReturn(true);
        ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class, "El usuario ya existe en el sistema");
    }

    @Test
    public void ActualizarUsuarioExitoso() {
        Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);

        when(repositorioUsuario.existeExcluyendoId(anyLong(), anyString())).thenReturn(false);
        doNothing().when(repositorioUsuario).actualizar(any(Usuario.class));

        servicioActualizarUsuario.ejecutar(usuario);

        verify(repositorioUsuario, times(1)).actualizar(any(Usuario.class));
        verify(repositorioUsuario, times(1)).existeExcluyendoId(anyLong(), anyString());
    }
}
