package com.ceiba.asesoria.servicio.testdatabuilder;

import com.ceiba.asesoria.model.entidad.Asesoria;

public class AsesoriaTestDataBuilder {

    private Long id;
    private Long idAsesor;
    private Integer horaInicio;
    private Integer horaFin;
    private String fechaAsesoria;

    public AsesoriaTestDataBuilder() {
        this.idAsesor = 1L;
        this.fechaAsesoria = "12/2/2021";
        this.horaInicio = 12;
        this.horaFin = 14;
    }

    public AsesoriaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public AsesoriaTestDataBuilder conHoraIncio(Integer horaInicio) {
        this.horaInicio = horaInicio;
        return this;
    }

    public AsesoriaTestDataBuilder conHoraFin(Integer horaFin) {
        this.horaFin = horaFin;
        return this;
    }

    public Asesoria build() {
        return new Asesoria(id, idAsesor, horaInicio, horaFin, fechaAsesoria);
    }
}
