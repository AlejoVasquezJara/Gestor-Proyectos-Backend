package com.sistemastransaccionales.gestorproyectos.mappers;

import com.sistemastransaccionales.gestorproyectos.dto.Personas;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonasMapper implements RowMapper<Personas> {
    @Override
    public Personas mapRow(ResultSet rs, int rowNum) throws SQLException {
        Personas entity = new Personas();
        entity.setIdunicpersona(rs.getString("idunicpersona"));
        entity.setRole(rs.getString("role"));
        entity.setDsnombre(rs.getString("dsnombre"));
        entity.setFenacimiento(rs.getTimestamp("fenacimiento").toLocalDateTime());
        entity.setIdproyecto(rs.getString("idproyecto"));
        return entity;
    }
}
