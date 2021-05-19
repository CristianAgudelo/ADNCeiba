package com.ceiba.asesoria.servicio.testdatabuilder;

import com.ceiba.asesoria.model.dto.DtoAsesoria;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.DtoUsuarioTestDataBuilder;

import java.time.LocalDate;

public class DtoAsesoriaTestDataBuilder {
    private Long id;
    private DtoUsuario asesor;
    private Integer horaInicio;
    private Integer horaFin;
    private LocalDate fechaAsesoria;
    private Integer duracion;

    public DtoAsesoriaTestDataBuilder() {
        this.fechaAsesoria = LocalDate.of(2020, 12, 21);
        this.horaInicio = 12;
        this.duracion = 2;
        this.horaFin = 14;
        this.asesor = new DtoUsuarioTestDataBuilder().build();
    }

    public DtoAsesoriaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DtoAsesoriaTestDataBuilder conHoraIncio(Integer horaInicio) {
        this.horaInicio = horaInicio;
        return this;
    }

    public DtoAsesoriaTestDataBuilder conHoraFin(Integer horaFin) {
        this.horaFin = horaFin;
        return this;
    }

    public DtoAsesoria build() {
        return new DtoAsesoria(id, asesor, horaInicio, horaFin, fechaAsesoria, duracion);
    }
}
