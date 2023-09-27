package com.sistemastransaccionales.gestorproyectos.dao;

import com.sistemastransaccionales.gestorproyectos.dto.Usuarios;

import java.util.List;

public interface UsuariosDAO {
    List<Usuarios> getAll();
    Usuarios getByinfo(Usuarios entity);
    Usuarios insert(Usuarios entity);
    Boolean delete(String id);
    Usuarios getById(String id);
}
