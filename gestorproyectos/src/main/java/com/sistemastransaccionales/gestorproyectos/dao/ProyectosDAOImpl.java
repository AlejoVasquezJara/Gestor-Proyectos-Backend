package com.sistemastransaccionales.gestorproyectos.dao;

import com.sistemastransaccionales.gestorproyectos.dto.Proyectos;
import com.sistemastransaccionales.gestorproyectos.mappers.ProyectosMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProyectosDAOImpl implements ProyectosDAO{
    private final String INSERT = "INSERT INTO proyectos\n" +
            "(idunicproyecto, dsproyecto, descripcion)\n" +
            "VALUES(?, ?, ?);\n";
    private final String UPDATE = "UPDATE proyectos\n" +
            "SET dsproyecto=?, descripcion=?\n" +
            "WHERE idunicproyecto=?;\n";
    private final String GETALL = "SELECT idunicproyecto, dsproyecto, descripcion\n" +
            "FROM proyectos;\n";
    private final String DELETE = "DELETE FROM proyectos\n where idunicproyecto=?;";
    private final String GETBYID = "SELECT idunicproyecto, dsproyecto, descripcion\n" +
            "FROM proyectos WHERE idunicproyecto = ?;";



    private JdbcTemplate jdbcTemplate;

    public ProyectosDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Proyectos> getAll() {
        return jdbcTemplate.query(GETALL, new ProyectosMapper());
    }

    @Override
    public Proyectos getById(String id) {
        try{
            return jdbcTemplate.queryForObject(GETBYID, new ProyectosMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Proyectos insert(Proyectos entity) {
        jdbcTemplate.update(INSERT, entity.getIdunicproyecto(), entity.getDsproyecto(), entity.getDescripcion());
        return entity;
    }

    @Override
    public Proyectos update(Proyectos entity) {
        jdbcTemplate.update(UPDATE, entity.getDsproyecto(), entity.getDescripcion(), entity.getIdunicproyecto());
        return entity;
    }

    @Override
    public Boolean delete(String id) {
        return jdbcTemplate.update(DELETE,id
        )>0;
    }

}
