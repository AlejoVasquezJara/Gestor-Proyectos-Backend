package com.sistemastransaccionales.gestorproyectos.mappers;

import com.sistemastransaccionales.gestorproyectos.dto.Usuarios;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosMapper implements RowMapper<Usuarios> {
    @Override
    public Usuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuarios entity = new Usuarios();
        entity.setIdunicuser(rs.getString("idunicuser"));
        entity.setUser(rs.getString("user"));
        entity.setPassword(rs.getString("password"));
        entity.setCorreo(rs.getString("correo"));
        entity.setIdpersona(rs.getString("idpersona"));
        return entity;
    }
}
