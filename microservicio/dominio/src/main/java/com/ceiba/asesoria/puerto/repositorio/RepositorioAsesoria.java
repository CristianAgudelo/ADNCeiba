package com.ceiba.asesoria.puerto.repositorio;

import com.ceiba.asesoria.model.entidad.Asesoria;

public interface RepositorioAsesoria {

    /**
     * Permite crear una Asesoria
     *
     * @param asesoria
     * @return el id generado
     */
    Long crear(Asesoria asesoria);

    /**
     * Permite actualizar una asesoria
     *
     * @param asesoria
     */
    void actualizar(Asesoria asesoria);

    /**
     * Permite eliminar una asesoria
     *
     * @param id
     */
    void eliminar(Long id);

}
