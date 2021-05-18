package com.ceiba.asesoria.comando.fabrica;

import com.ceiba.asesoria.comando.ComandoAsesoria;
import com.ceiba.asesoria.model.entidad.Asesoria;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FabricaAsesoria {

    private final FabricaUsuario fabricaUsuario;
    private final DaoUsuario daoUsuario;

    public Asesoria crear(ComandoAsesoria comandoAsesoria) {
        DtoUsuario dtoUsuario = daoUsuario.buscarPorid(comandoAsesoria.getIdAsesor());
        Usuario usuario = fabricaUsuario.crear(dtoUsuario);

        return new Asesoria(
                comandoAsesoria.getId(),
                usuario.getId(),
                comandoAsesoria.getHoraInicio(),
                comandoAsesoria.getHoraFin(),
                comandoAsesoria.getFechaAsesoria()
        );
    }
}
