package com.ceiba.asesoria.adapatador.dao;

import com.ceiba.asesoria.model.dto.DtoAsesoria;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoAsesoria implements RowMapper<DtoAsesoria>, MapperResult {
    @Override
    public DtoAsesoria mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        DtoUsuario dtoUsuario = new DtoUsuario(resultSet
                .getLong("asesor"), resultSet.getString("nombre"));
        Integer horaInicio = resultSet.getObject("hora_inicio", Integer.class);
        Integer horaFin = resultSet.getObject("hora_fin", Integer.class);
        LocalDate fecha = extraerLocalDate(resultSet, "fecha_asesoria");
        Integer duracion = resultSet.getObject("duracion", Integer.class);

        return new DtoAsesoria(id, dtoUsuario, horaInicio, horaFin, fecha, duracion);
    }
}
