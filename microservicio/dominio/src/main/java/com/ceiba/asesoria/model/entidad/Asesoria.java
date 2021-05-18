package com.ceiba.asesoria.model.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Asesoria {

    private static final Integer DURACION_MINIMA_ASESORIA = 1;
    private static final Integer DURACION_MAXIMA_ASESORIA = 3;
    private static final Integer HORA_APERTURA_VALIDA_DEL_DIA = 7;
    private static final Integer HORA_CIERRE_VALIDA_DEL_DIA = 22;
    private static final String FORMATO_FECHA = "dd/mm/yyyy";
    private static final String FORMATO_FECHA_NO_VALIDO = "EL FORMATO DE LA FECHA DEBE SER DD/MM/YYYY";
    private static final String HORA_DEL_DIA_NO_VALIDA = "LA HORA DE LA ASESORIA NO ES VALIDA";
    private static final String DURACION_NO_ES_VALIDA = "LA DURACIÓN MAXIMA DE LA ASESORIA ES 3 HORAS Y LA MINIMA 1";
    private static final String SE_DEBE_INGRESAR_ASESOR = "SE DEBE DE INGRESAR UN ASESOR ASOCIADO A LA ASESORIA";
    private static final String SE_DEBE_INGRESAR_HORA_INICIO = "SE DEBE INGRESAS UNA HORA DE INICIO PARA LA ASESORIA";
    private static final String SE_DEBE_INGRESAR_HORA_FIN = "SE DEBE INGRESAS UNA HORA DE FINALIZACIÓN PARA LA ASESORIA";
    private static final String SE_DEBE_INGRESAR_FECHA = "SE DEBE DE INGRESAR FECHA DE LA ASESORIA";

    private Long id;
    private Long asesor;
    private Integer horaInicio;
    private Integer horaFin;
    private LocalDate fechaAsesoria;
    private Integer duracion;

    public Asesoria(
            Long id, Long asesor, Integer horaInicio, Integer horaFin,
            String fechaAsesoria) {
        this.fechaAsesoria = convertirFecha(fechaAsesoria);
        validarReglas(asesor, horaInicio, horaFin);
        this.id = id;
        this.asesor = asesor;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.duracion = calcularHoras(horaInicio, horaFin);
    }

    private void validarReglas(Long asesor, Integer horaInicio, Integer horaFin) {
        validarObligatorio(asesor, SE_DEBE_INGRESAR_ASESOR);
        validarObligatorio(horaInicio, SE_DEBE_INGRESAR_HORA_INICIO);
        validarObligatorio(horaFin, SE_DEBE_INGRESAR_HORA_FIN);
        validarRango(horaFin, HORA_APERTURA_VALIDA_DEL_DIA, HORA_CIERRE_VALIDA_DEL_DIA, HORA_DEL_DIA_NO_VALIDA);
        validarRango(horaInicio, HORA_APERTURA_VALIDA_DEL_DIA, HORA_CIERRE_VALIDA_DEL_DIA, HORA_DEL_DIA_NO_VALIDA);
    }

    private Integer calcularHoras(Integer horaInicio, Integer horaFin) {
        Integer duracionAsesoria = horaFin - horaInicio;
        validarMayor(duracionAsesoria, DURACION_MINIMA_ASESORIA, DURACION_NO_ES_VALIDA);
        validarMenor(duracionAsesoria, DURACION_MAXIMA_ASESORIA, DURACION_NO_ES_VALIDA);
        return duracionAsesoria;
    }

    private LocalDate convertirFecha(String fecha) {
        validarObligatorio(fecha, SE_DEBE_INGRESAR_FECHA);
        validarFormatoFecha(fecha, FORMATO_FECHA, FORMATO_FECHA_NO_VALIDO);
        String[] fechaFormato = fecha.split("/");
        return LocalDate.of(Integer.parseInt(fechaFormato[2]),
                Integer.parseInt(fechaFormato[1]), Integer.parseInt(fechaFormato[0]));
    }
}
