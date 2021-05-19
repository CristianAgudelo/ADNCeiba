package com.ceiba.asesoria.adapatador.repositorio;

import com.ceiba.asesoria.model.entidad.Asesoria;
import com.ceiba.asesoria.puerto.repositorio.RepositorioAsesoria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAsesoriaMysql implements RepositorioAsesoria {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="asesoria", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="asesoria", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="asesoria", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="asesoria", value="existePorId")
    private static String sqlExistePorId;


    public RepositorioAsesoriaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long crear(Asesoria asesoria) {
        return customNamedParameterJdbcTemplate.crear(asesoria, sqlCrear);
    }

    @Override
    public void actualizar(Asesoria asesoria) {
        customNamedParameterJdbcTemplate.actualizar(asesoria, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

}
