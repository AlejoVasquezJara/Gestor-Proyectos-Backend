package com.sistemastransaccionales.gestorproyectos.services;

import com.sistemastransaccionales.gestorproyectos.dao.ProyectosDAO;
import com.sistemastransaccionales.gestorproyectos.dto.Proyectos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
@Service
public class ProyectosServiceImpl implements ProyectosService{
    @Autowired
    private ProyectosDAO proyectosDAO;

    @Override
    public List<Proyectos> getAll() {
        return proyectosDAO.getAll();
    }

    @Override
    public Proyectos getById(String id) {
        return proyectosDAO.getById(id);
    }

    @Override
    public Proyectos insertorupdate(Proyectos entity) throws ParseException {

        String uuid = java.util.UUID.randomUUID().toString().replace("-", "");
        Proyectos  _TarpProyecto= proyectosDAO.getById(entity.getIdunicproyecto());
        if(_TarpProyecto==null){

            entity.setIdunicproyecto(uuid);
            return proyectosDAO.insert(entity);

        }else{
            return proyectosDAO.update(entity);
        }
    }

    @Override
    public Boolean delete(String id) {
        return proyectosDAO.delete(id);
    }
}
