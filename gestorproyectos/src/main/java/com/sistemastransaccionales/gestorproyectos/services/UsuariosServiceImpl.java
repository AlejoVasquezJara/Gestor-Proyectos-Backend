package com.sistemastransaccionales.gestorproyectos.services;

import com.sistemastransaccionales.gestorproyectos.dao.UsuariosDAO;
import com.sistemastransaccionales.gestorproyectos.dto.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private UsuariosDAO dao;

    @Override
    public List<Usuarios> getAll() {
        return dao.getAll();
    }

    @Override
    public Usuarios getByinfo(Usuarios entity) {
        return dao.getByinfo(entity);
    } //Informacion del login

    @Override
    public Usuarios insert(Usuarios entity) {
        String uuid = java.util.UUID.randomUUID().toString().replace("-", "");
        Usuarios _Tarpusuarios= dao.getById(entity.getIdunicuser());
        if(_Tarpusuarios==null){

            entity.setIdunicuser(uuid);
            return dao.insert(entity);

        }
        return entity;
    }

    @Override
    public Boolean delete(String id) {
        return dao.delete(id);
    }

    @Override
    public Usuarios getById(String id) {
        return dao.getById(id);
    }
}
