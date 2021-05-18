package com.ceiba.asesoria.servicio;

import com.ceiba.asesoria.puerto.repositorio.RepositorioAsesoria;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicioEliminarAsesoria {

    private final RepositorioAsesoria repositorioAsesoria;

    public void ejecutar(Long id) {
        repositorioAsesoria.eliminar(id);
    }
}
