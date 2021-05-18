package com.ceiba.asesoria.model.dto;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class DtoAsesoria {
    private final Long id;
    private final DtoUsuario asesor;
    private final Integer horaInicio;
    private final Integer horaFin;
    private final LocalDate fechaAsesoria;
    private final Integer duracion;
}
