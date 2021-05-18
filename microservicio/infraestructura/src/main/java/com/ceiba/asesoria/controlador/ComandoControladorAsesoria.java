package com.ceiba.asesoria.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.asesoria.comando.ComandoAsesoria;
import com.ceiba.asesoria.comando.manejador.ManejadorActualizarAsesoria;
import com.ceiba.asesoria.comando.manejador.ManejadorCrearAsesoria;
import com.ceiba.asesoria.comando.manejador.ManejadorEliminarAsesoria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asesorias")
@Api(tags = { "Controlador comando asesorias"})
public class ComandoControladorAsesoria {

    private final ManejadorEliminarAsesoria  manejadorEliminarAsesoria;
    private final ManejadorActualizarAsesoria manejadorActualizarAsesoria;
    private final ManejadorCrearAsesoria manejadorCrearAsesoria;

    @Autowired
    public ComandoControladorAsesoria(ManejadorEliminarAsesoria manejadorEliminarAsesoria,
                                      ManejadorActualizarAsesoria manejadorActualizarAsesoria,
                                      ManejadorCrearAsesoria manejadorCrearAsesoria) {
        this.manejadorEliminarAsesoria = manejadorEliminarAsesoria;
        this.manejadorActualizarAsesoria = manejadorActualizarAsesoria;
        this.manejadorCrearAsesoria = manejadorCrearAsesoria;
    }

    @PostMapping
    @ApiOperation("Crear asesoria")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAsesoria comandoAsesoria){
        return manejadorCrearAsesoria.ejecutar(comandoAsesoria);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Asesoria")
    public void eliminar(@PathVariable Long id){
        manejadorEliminarAsesoria.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar asesoria")
    public void actualizar(@RequestBody ComandoAsesoria comandoAsesoria, @PathVariable Long id){
        comandoAsesoria.setId(id);
        manejadorActualizarAsesoria.ejecutar(comandoAsesoria);
    }
}
