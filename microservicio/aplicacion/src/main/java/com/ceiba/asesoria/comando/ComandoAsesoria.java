package com.ceiba.asesoria.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoAsesoria {
    private Long id;
    private Long idAsesor;
    private Integer horaInicio;
    private Integer horaFin;
    private String fechaAsesoria;
}
