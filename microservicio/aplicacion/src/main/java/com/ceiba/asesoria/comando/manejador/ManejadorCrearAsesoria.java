package com.ceiba.asesoria.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.asesoria.comando.ComandoAsesoria;
import com.ceiba.asesoria.comando.fabrica.FabricaAsesoria;
import com.ceiba.asesoria.model.entidad.Asesoria;
import com.ceiba.asesoria.servicio.ServicioCrearAsesoria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ManejadorCrearAsesoria {

    private final FabricaAsesoria fabricaAsesoria;
    private final ServicioCrearAsesoria servicioCrearAsesoria;

    public ComandoRespuesta<Long> ejecutar(ComandoAsesoria comandoAsesoria) {
        Asesoria asesoria = fabricaAsesoria.crear(comandoAsesoria);
        return new ComandoRespuesta<>(servicioCrearAsesoria.ejecutar(asesoria));
    }
}
