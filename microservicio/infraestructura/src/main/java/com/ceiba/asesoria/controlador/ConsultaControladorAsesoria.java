package com.ceiba.asesoria.controlador;

import com.ceiba.asesoria.consulta.ManejadorListarAsesorias;
import com.ceiba.asesoria.model.dto.DtoAsesoria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asesorias")
@Api(tags = {"Controlador consulta asesorias"})
public class ConsultaControladorAsesoria {

    private final ManejadorListarAsesorias manejadorListarAsesorias;

    public ConsultaControladorAsesoria(ManejadorListarAsesorias manejadorListarAsesorias) {
        this.manejadorListarAsesorias = manejadorListarAsesorias;
    }

    @GetMapping("/{nombre}/{mes}")
    @ApiOperation("Listar asesorias")
    public List<DtoAsesoria> listar(@PathVariable String nombre, @PathVariable Integer mes) {
        return manejadorListarAsesorias.ejecutar(nombre, mes);
    }
}
