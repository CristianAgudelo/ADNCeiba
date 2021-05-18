package com.ceiba.usuario.servicio;

import com.ceiba.asesoria.puerto.dao.DaoAsesoria;
import com.ceiba.dominio.excepcion.ExepcionNoSePuedeEliminar;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicioEliminarUsuario {

    private static final String NO_SE_PUEDE_ELIMNAR = "No se puede eliminar el usuario porque tiene asesorias";

    private final RepositorioUsuario repositorioUsuario;
    private final DaoAsesoria daoAsesoria;
    private final DaoUsuario daoUsuario;

    public void ejecutar(Long id) {
        validarEliminacion(id);
        this.repositorioUsuario.eliminar(id);
    }

    private void validarEliminacion(Long id) {
        DtoUsuario usuario = daoUsuario.buscarPorid(id);
        boolean existe = daoAsesoria.listarPorAsesor(usuario.getNombre(), usuario.getId()).isEmpty();
        if (!existe) {
            throw new ExepcionNoSePuedeEliminar(NO_SE_PUEDE_ELIMNAR);
        }
    }
}
