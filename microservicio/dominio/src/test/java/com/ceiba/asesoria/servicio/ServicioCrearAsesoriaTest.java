package com.ceiba.asesoria.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.asesoria.model.dto.DtoAsesoria;
import com.ceiba.asesoria.model.entidad.Asesoria;
import com.ceiba.asesoria.puerto.dao.DaoAsesoria;
import com.ceiba.asesoria.puerto.repositorio.RepositorioAsesoria;
import com.ceiba.asesoria.servicio.testdatabuilder.AsesoriaTestDataBuilder;
import com.ceiba.asesoria.servicio.testdatabuilder.DtoAsesoriaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExepcionNoExisteAsesor;
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

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class ServicioCrearAsesoriaTest {

    @InjectMocks
    private ServicioCrearAsesoria servicioCrearAsesoria;

    @Mock
    private RepositorioAsesoria repositorioAsesoria;

    @Mock
    private RepositorioUsuario repositorioUsuario;

    @Mock
    private DaoAsesoria daoAsesoria;

    @Mock
    private DaoUsuario daoUsuario;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crearExitoso() {
        Asesoria asesoria = new AsesoriaTestDataBuilder().build();

        when(repositorioUsuario.existe(anyLong())).thenReturn(true);
        when(daoUsuario.buscarPorid(anyLong())).thenReturn(new DtoUsuarioTestDataBuilder().build());
        when(daoAsesoria.listarPorAsesor(anyString())).thenReturn(new ArrayList<>());
        when(repositorioAsesoria.crear(any(Asesoria.class))).thenReturn(1L);

        servicioCrearAsesoria.ejecutar(asesoria);
        verify(repositorioUsuario, times(1)).existe(anyLong());
        verify(repositorioAsesoria, times(1)).crear(any(Asesoria.class));
        verify(daoAsesoria, times(1)).listarPorAsesor(anyString());
        verify(daoUsuario, times(1)).buscarPorid(anyLong());

    }

    @Test
    public void ActualizarSinAsesor() {
        Asesoria asesoria = new AsesoriaTestDataBuilder().build();

        when(repositorioUsuario.existe(anyLong())).thenReturn(false);
        BasePrueba.assertThrows(() -> servicioCrearAsesoria.ejecutar(asesoria), ExepcionNoExisteAsesor.class, "El asesor que se indica no existe");
    }

    @Test
    public void ActulizarHoraValida() {
        Asesoria asesoria = new AsesoriaTestDataBuilder().build();
        DtoAsesoria dtoAsesoria = new DtoAsesoriaTestDataBuilder().build();
        List<DtoAsesoria> list = new ArrayList<>();
        list.add(dtoAsesoria);

        when(daoUsuario.buscarPorid(anyLong())).thenReturn(new DtoUsuarioTestDataBuilder().build());
        when(repositorioUsuario.existe(anyLong())).thenReturn(true);
        when(daoAsesoria.listarPorAsesor(anyString())).thenReturn(list);
        when(repositorioAsesoria.crear(any(Asesoria.class))).thenReturn(1L);

        servicioCrearAsesoria.ejecutar(asesoria);

        verify(repositorioUsuario, times(1)).existe(anyLong());
        verify(repositorioAsesoria, times(1)).crear(any(Asesoria.class));
        verify(daoAsesoria, times(1)).listarPorAsesor(anyString());

    }

    @Test
    public void ActulizarHoraNoValida() {
        Asesoria asesoria = new AsesoriaTestDataBuilder().conHoraIncio(13).build();
        DtoAsesoria dtoAsesoria = new DtoAsesoriaTestDataBuilder().build();
        List<DtoAsesoria> list = new ArrayList<>();
        list.add(dtoAsesoria);

        when(daoUsuario.buscarPorid(anyLong())).thenReturn(new DtoUsuarioTestDataBuilder().build());
        when(repositorioUsuario.existe(anyLong())).thenReturn(true);
        when(daoAsesoria.listarPorAsesor(anyString())).thenReturn(list);

        BasePrueba.assertThrows(() -> servicioCrearAsesoria.ejecutar(asesoria), ExcepcionValorInvalido.class, "El asesor tiene otra asesoría en el mimso horario");
    }

    @Test
    public void ActulizarHoraFinNoValida() {
        Asesoria asesoria = new AsesoriaTestDataBuilder().conHoraFin(13).build();
        DtoAsesoria dtoAsesoria = new DtoAsesoriaTestDataBuilder().build();
        List<DtoAsesoria> list = new ArrayList<>();
        list.add(dtoAsesoria);

        when(daoUsuario.buscarPorid(anyLong())).thenReturn(new DtoUsuarioTestDataBuilder().build());
        when(repositorioUsuario.existe(anyLong())).thenReturn(true);
        when(daoAsesoria.listarPorAsesor(anyString())).thenReturn(list);

        BasePrueba.assertThrows(() -> servicioCrearAsesoria.ejecutar(asesoria), ExcepcionValorInvalido.class, "El asesor tiene otra asesoría en el mimso horario");
    }
}