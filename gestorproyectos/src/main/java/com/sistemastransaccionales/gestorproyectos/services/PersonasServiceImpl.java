package com.sistemastransaccionales.gestorproyectos.services;

import com.sistemastransaccionales.gestorproyectos.dao.PersonasDAO;
import com.sistemastransaccionales.gestorproyectos.dto.Personas;
import com.sistemastransaccionales.gestorproyectos.dto.Proyectos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonasServiceImpl implements PersonasService{
    @Autowired
    private PersonasDAO dao;

    @Override
    public List<Personas> getAll() {
        return dao.getAll();
    }

    @Override
    public Personas getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Personas insert(Personas entity) {
        Personas TarpPersonas= dao.getById(entity.getIdunicpersona()); //Busca el ID si existe la Actualiza, Si esta nulo la inserta
        if(TarpPersonas==null){
            return dao.insert(entity);

        }else{
            return dao.update(entity);
        }
    }

    @Override
    public Boolean delete(String id) {
        return dao.delete(id);
    }

    @Override
    public List<Map<String, Object>> getdatabypersona(String id) {
        return dao.getdatabypersona(id);
    } //Obtiene Informacion de la persona

    @Override
    public List<Personas> getintegrantesproyecto(String id) {
        return dao.getintegrantesproyecto(id);
    } //Obtiene Integrante Proyecto

    @Override
    public Personas updateproyecto(Personas entity) {
        return dao.updateproyecto(entity);
    } //Actualiza el proyecto dependiendo de la persona
}
