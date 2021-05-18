package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class DtoUsuarioTestDataBuilder {

    private Long id;
    private String nombreUsuario;

    public DtoUsuarioTestDataBuilder() {
        nombreUsuario = "1234";
    }


    public DtoUsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DtoUsuario build() {
        return new DtoUsuario(id,nombreUsuario);
    }
}
