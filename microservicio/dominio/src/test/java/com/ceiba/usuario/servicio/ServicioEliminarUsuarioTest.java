package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.asesoria.model.dto.DtoAsesoria;
import com.ceiba.asesoria.model.entidad.Asesoria;
import com.ceiba.asesoria.puerto.dao.DaoAsesoria;
import com.ceiba.dominio.excepcion.ExepcionNoSePuedeEliminar;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.DtoUsuarioTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class ServicioEliminarUsuarioTest {

    @InjectMocks
    private ServicioEliminarUsuario servicioEliminarUsuario;

    @Mock
    private DaoUsuario daoUsuario;

    @Mock
    private DaoAsesoria daoAsesoria;

    @Mock
    private RepositorioUsuario repositorioUsuario;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void eliminarUsuarioValido() {
        Long id = 1L;
        DtoUsuario usuario = new DtoUsuarioTestDataBuilder().conId(id).build();

        when(daoAsesoria.listarPorAsesor(anyString(), anyLong())).thenReturn(new ArrayList<>());
        when(daoUsuario.buscarPorid(anyLong())).thenReturn(usuario);
        doNothing().when(repositorioUsuario).eliminar(anyLong());

        servicioEliminarUsuario.ejecutar(id);

        verify(daoAsesoria, times(1)).listarPorAsesor(anyString(), anyLong());
        verify(daoUsuario, times(1)).buscarPorid(anyLong());
        verify(repositorioUsuario, times(1)).eliminar(anyLong());
    }

    @Test
    public void eliminarUsuarioNoValido() {
        Long id = 1L;
        DtoUsuario usuario = new DtoUsuarioTestDataBuilder().conId(id).build();
        List<DtoAsesoria> list = new ArrayList<>();
        DtoAsesoria asesoria = mock(DtoAsesoria.class);
        list.add(asesoria);

        when(daoAsesoria.listarPorAsesor(anyString(), anyLong())).thenReturn(list);
        when(daoUsuario.buscarPorid(anyLong())).thenReturn(usuario);

        BasePrueba.assertThrows(() -> servicioEliminarUsuario.ejecutar(id), ExepcionNoSePuedeEliminar.class, "No se puede eliminar el usuario porque tiene asesorias");

        verify(daoAsesoria, times(1)).listarPorAsesor(anyString(), anyLong());
        verify(daoUsuario, times(1)).buscarPorid(anyLong());
        verify(repositorioUsuario, times(0)).eliminar(anyLong());
    }
}
