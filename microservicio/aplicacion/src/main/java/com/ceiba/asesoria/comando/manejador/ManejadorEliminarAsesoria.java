package com.ceiba.asesoria.comando.manejador;

import com.ceiba.asesoria.servicio.ServicioEliminarAsesoria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ManejadorEliminarAsesoria {

    private final ServicioEliminarAsesoria servicioEliminarAsesoria;

    public void ejecutar(Long idAsesoria) {
        servicioEliminarAsesoria.ejecutar(idAsesoria);
    }
}
