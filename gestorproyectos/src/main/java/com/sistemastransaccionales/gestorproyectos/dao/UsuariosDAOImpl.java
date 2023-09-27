package com.sistemastransaccionales.gestorproyectos.dao;

import com.sistemastransaccionales.gestorproyectos.dto.Usuarios;
import com.sistemastransaccionales.gestorproyectos.mappers.UsuariosMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuariosDAOImpl implements UsuariosDAO{

    private final String INSERT = "insert into usuarios (idunicuser, user, password, idpersona, correo)\n" +
            "values (?, ?, ?, ?, ?);";
    private final String DELETE = "delete\n" +
            "from usuarios\n" +
            "where idunicuser = ?;";
    private final String GETBYINFO= "SELECT *\n" +
            "FROM usuarios\n" +
            "WHERE correo = ?\n" +
            "AND password = ?;";
    private final String GETALL= "SELECT idunicuser, `user`, password, idpersona, correo\n" +
            "FROM usuarios;\n";

    private final String GETBYID = "SELECT * FROM usuarios WHERE idunicuser = ?";

    private JdbcTemplate jdbcTemplate;

    public UsuariosDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Usuarios> getAll() {
        return jdbcTemplate.query(GETALL, new UsuariosMapper());
    }

    @Override
    public Usuarios getByinfo(Usuarios entity) {
        try{
            return jdbcTemplate.queryForObject(GETBYINFO, new UsuariosMapper(),entity.getCorreo(), entity.getPassword());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Usuarios insert(Usuarios entity) {
        jdbcTemplate.update(INSERT, entity.getIdunicuser(), entity.getUser(), entity.getPassword(), entity.getIdpersona(), entity.getCorreo());
        return entity;
    }

    @Override
    public Boolean delete(String id) {
        return jdbcTemplate.update(DELETE,id
        )>0;
    }

    @Override
    public Usuarios getById(String id) {
        try{
            return jdbcTemplate.queryForObject(GETBYID, new UsuariosMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }
}
