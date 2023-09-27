package com.sistemastransaccionales.gestorproyectos.dao;

import com.sistemastransaccionales.gestorproyectos.dto.Personas;
import com.sistemastransaccionales.gestorproyectos.mappers.PersonasMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PersonasDAOImpl implements PersonasDAO{
    private JdbcTemplate jdbcTemplate;

    public PersonasDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String INSERT = "INSERT INTO personas\n" +
            "(idunicpersona, dsnombre, fenacimiento, `role`, idproyecto)\n" +
            "VALUES(?, ?, ?, ?, ?);\n";
    private final String UPDATE = "UPDATE personas\n" +
            "SET dsnombre=?, fenacimiento=?, `role`=?, idproyecto=?\n" +
            "WHERE idunicpersona=?;\n";
    private final String GETALL = "SELECT idunicpersona, dsnombre, fenacimiento, `role`, idproyecto\n" + //Obtener todos los registros de tabla personas
            "FROM personas;\n";
    private final String DELETE = "DELETE FROM personas\n" + //Eliminar una persona con el Id
            "WHERE idunicpersona=?;\n";
    private final String GETBYID = "SELECT idunicpersona, dsnombre, fenacimiento, `role`, idproyecto\n" +
            "FROM personas WHERE idunicpersona = ?;"; //Obtener una persona especifica de la tabla personas

    private final String GETPROYECT_BY_PERSONA = "SELECT pp.idunicpersona,\n" + //obtendra el pryecto segun la persona (Integrante,Usuario,Admin)
            "       pp.dsnombre,\n" +
            "       pp.fenacimiento,\n" +
            "       pp.role,\n" +
            "       proyect.dsproyecto,\n" +
            "       proyect.descripcion,\n" +
            "       proyect.idunicproyecto\n" +
            "FROM  personas pp\n" +
            "INNER JOIN proyectos proyect ON pp.idproyecto = proyect.idunicproyecto\n" +
            "WHERE idunicpersona = ?";

    private final String  getbyproyecto= "SELECT pp.idunicpersona,\n" + //obtendra Inf persona relacionada al proyecto
            "       pp.dsnombre,\n" +
            "       pp.fenacimiento,\n" +
            "       pp.role,\n" +
            "       pp.idproyecto\n" +
            "FROM  personas pp WHERE idproyecto = ?;";

    private final String updateproyect= "update personas\n" + //actualiza el rol de una persona en un proyecto
            "set  idproyecto= ?,role=?\n" +
            "where idunicpersona = ?;";

    @Override
    public List<Personas> getAll() {
        return jdbcTemplate.query(GETALL, new PersonasMapper());
    }

    @Override
    public Personas getById(String id) {
        try{
            return jdbcTemplate.queryForObject(GETBYID, new PersonasMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> getdatabypersona(String id) {
        try{
            return jdbcTemplate.queryForList(GETPROYECT_BY_PERSONA,id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Personas insert(Personas entity) {
        jdbcTemplate.update(INSERT, entity.getIdunicpersona(), entity.getDsnombre(), entity.getFenacimiento(), entity.getRole(), entity.getIdproyecto());
        return entity;
    }

    @Override
    public Personas update(Personas entity) {
        jdbcTemplate.update(INSERT, entity.getDsnombre(), entity.getFenacimiento(), entity.getRole(), entity.getIdproyecto(),entity.getIdunicpersona());
        return entity;
    }

    @Override
    public Boolean delete(String id) {
        return jdbcTemplate.update(DELETE,id
        )>0;
    }

    @Override
    public List<Personas> getintegrantesproyecto(String id) {
        return jdbcTemplate.query(getbyproyecto, new PersonasMapper(), id);
    }

    @Override
    public Personas updateproyecto(Personas entity) {
        jdbcTemplate.update(updateproyect, entity.getIdproyecto(),  entity.getRole(),entity.getIdunicpersona());
        return entity;
    }
}
