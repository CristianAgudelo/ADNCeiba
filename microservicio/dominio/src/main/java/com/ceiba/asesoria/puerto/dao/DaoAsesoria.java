package com.ceiba.asesoria.puerto.dao;

import com.ceiba.asesoria.model.dto.DtoAsesoria;

import java.util.List;

public interface DaoAsesoria {

    /**
     * Permite listar Asesorias por nombre de asesor
     * @Param nombreAsesor
     * @return los Asesorias
     */
    List<DtoAsesoria> listarPorAsesor(String nombreAsesor);

    /**
     * Permite listar Asesorias por nombre de asesor excluyendo el id asesoria
     * @param nombreAsesor id
     * @return los Asesorias
     */
    List<DtoAsesoria> listarPorAsesor(String nombreAsesor, Long id);
}
