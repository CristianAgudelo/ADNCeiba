package com.ceiba.asesoria.comando.manejador;

import com.ceiba.asesoria.comando.ComandoAsesoria;
import com.ceiba.asesoria.comando.fabrica.FabricaAsesoria;
import com.ceiba.asesoria.model.entidad.Asesoria;
import com.ceiba.asesoria.servicio.ServicioActualizarAsesoria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ManejadorActualizarAsesoria {

    private final FabricaAsesoria fabricaAsesoria;
    private final ServicioActualizarAsesoria servicioActualizarAsesoria;

    public void ejecutar(ComandoAsesoria comandoAsesoria){
        Asesoria asesoria = fabricaAsesoria.crear(comandoAsesoria);
        servicioActualizarAsesoria.ejecutar(asesoria);
    }
}
