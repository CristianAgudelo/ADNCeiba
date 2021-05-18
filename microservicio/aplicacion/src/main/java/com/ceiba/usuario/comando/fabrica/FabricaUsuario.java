package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuario {

    public Usuario crear(ComandoUsuario comandoUsuario) {
        return new Usuario(
                comandoUsuario.getId(),
                comandoUsuario.getNombre()
        );
    }

    public Usuario crear(DtoUsuario dtoUsuario) {
        return new Usuario(
                dtoUsuario.getId(),
                dtoUsuario.getNombre()
        );
    }

}
