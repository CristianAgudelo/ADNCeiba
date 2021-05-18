package com.ceiba.asesoria.servicio;

import com.ceiba.asesoria.model.entidad.Asesoria;
import com.ceiba.asesoria.puerto.dao.DaoAsesoria;
import com.ceiba.asesoria.puerto.repositorio.RepositorioAsesoria;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExepcionNoExisteAsesor;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicioCrearAsesoria {

    private static final String NO_EXISTE_ASESOR = "El asesor que se indica no existe";
    private static final String HORA_NO_VALIDA = "El asesor tiene otra asesoría en el mimso horario";

    private final RepositorioAsesoria repositorioAsesoria;
    private final DaoAsesoria daoAsesoria;
    private final RepositorioUsuario repositorioUsuario;
    private final DaoUsuario daoUsuario;

    public Long ejecutar(Asesoria asesoria) {
        validarAsesoria(asesoria);
        return repositorioAsesoria.crear(asesoria);
    }

    private void validarAsesoria(Asesoria asesoria) {

        if (!repositorioUsuario.existe(asesoria.getAsesor())) {
            throw new ExepcionNoExisteAsesor(NO_EXISTE_ASESOR);
        }
        DtoUsuario dtoUsuario = daoUsuario.buscarPorid(asesoria.getAsesor());
        daoAsesoria.listarPorAsesor(dtoUsuario.getNombre()).forEach(dtoAsesoria -> {
            if (validarHoraValida(asesoria.getHoraFin(), dtoAsesoria.getHoraInicio(), dtoAsesoria.getHoraFin())
                    || validarHoraValida(asesoria.getHoraInicio(), dtoAsesoria.getHoraInicio(), dtoAsesoria.getHoraFin())) {
                throw new ExcepcionValorInvalido(HORA_NO_VALIDA);
            }
        });
    }


    private Boolean validarHoraValida(Integer valor, Integer horaInicio, Integer horaFin) {
        return horaInicio < valor && valor < horaFin;
    }

}
