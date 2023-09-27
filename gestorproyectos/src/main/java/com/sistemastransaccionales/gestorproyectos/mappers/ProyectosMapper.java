package com.sistemastransaccionales.gestorproyectos.mappers;

import com.sistemastransaccionales.gestorproyectos.dto.Proyectos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProyectosMapper implements RowMapper<Proyectos> {

    @Override
    public Proyectos mapRow(ResultSet rs, int rowNum) throws SQLException {
        Proyectos entity = new Proyectos();
        entity.setIdunicproyecto(rs.getString("idunicproyecto"));
        entity.setDsproyecto(rs.getString("dsproyecto"));
        entity.setDescripcion(rs.getString("descripcion"));
        return entity;
    }
}
