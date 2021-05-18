package com.ceiba.asesoria.consulta;

import com.ceiba.asesoria.model.dto.DtoAsesoria;
import com.ceiba.asesoria.puerto.dao.DaoAsesoria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ManejadorListarAsesorias {
    private final DaoAsesoria daoAsesoria;

    public List<DtoAsesoria> ejecutar(String nombre, Integer mes){
        return daoAsesoria.listarPorAsesor(nombre).stream()
                .filter(dtoAsesoria ->
                        mes.equals(dtoAsesoria.getFechaAsesoria().getMonthValue()) )
                .collect(Collectors.toList());
    }
}
