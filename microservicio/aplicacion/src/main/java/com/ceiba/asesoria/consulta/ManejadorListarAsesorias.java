package com.ceiba.asesoria.consulta;

import com.ceiba.asesoria.model.dto.DtoAsesoria;
import com.ceiba.asesoria.puerto.dao.DaoAsesoria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ManejadorListarAsesorias {
    private final DaoAsesoria daoAsesoria;

    public List<DtoAsesoria> ejecutar(String nombre){
        return daoAsesoria.listarPorAsesor(nombre);
    }
}
