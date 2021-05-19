package com.ceiba.asesoria.adapatador.dao;

import com.ceiba.asesoria.model.dto.DtoAsesoria;
import com.ceiba.asesoria.puerto.dao.DaoAsesoria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoAsesoriaMysql implements DaoAsesoria {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "asesoria", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "asesoria", value = "listarPorAsesor")
    private static String sqlListarPorNombre;

    @SqlStatement(namespace = "asesoria", value = "listarPorAsesorExcluyendoId")
    private static String sqlListarPorNombreExcluyendoId;

    public DaoAsesoriaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoAsesoria> listarPorAsesor(String nombreAsesor) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombreAsesor);
        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorNombre, paramSource,
                new MapeoAsesoria());
    }

    @Override
    public List<DtoAsesoria> listarPorAsesor(String nombreAsesor, Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombreAsesor);
        paramSource.addValue("id", id);
        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorNombreExcluyendoId,
                paramSource, new MapeoAsesoria());
    }
}
