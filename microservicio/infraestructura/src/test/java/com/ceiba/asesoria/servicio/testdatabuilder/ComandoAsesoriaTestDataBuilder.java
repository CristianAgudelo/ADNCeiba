package com.ceiba.asesoria.servicio.testdatabuilder;

import com.ceiba.asesoria.comando.ComandoAsesoria;

public class ComandoAsesoriaTestDataBuilder {
    private Long id;
    private Long idAsesor;
    private Integer horaInicio;
    private Integer horaFin;
    private String fechaAsesoria;

    public ComandoAsesoriaTestDataBuilder() {
        idAsesor = 1L;
        fechaAsesoria = "12/12/2021";
        horaFin = 21;
        horaInicio = 20;
    }

    public ComandoAsesoriaTestDataBuilder conHoraFin(Integer horaFin) {
        this.horaFin = horaFin;
        return this;
    }

    public ComandoAsesoriaTestDataBuilder conHoraInicio(Integer horaInicio) {
        this.horaInicio = horaInicio;
        return this;
    }

    public ComandoAsesoriaTestDataBuilder conAsesor(Long asesor) {
        this.idAsesor = asesor;
        return this;
    }

    public ComandoAsesoriaTestDataBuilder conFecha(String fechaAsesoria) {
        this.fechaAsesoria = fechaAsesoria;
        return this;
    }

    public ComandoAsesoria build() {
        return new ComandoAsesoria(id,idAsesor, horaInicio, horaFin, fechaAsesoria);
    }
}
