package com.sistemastransaccionales.gestorproyectos.services;

import com.sistemastransaccionales.gestorproyectos.dto.Usuarios;

import java.util.List;

public interface UsuariosService {

    List<Usuarios> getAll();
    Usuarios getByinfo(Usuarios entity);

    Usuarios insert(Usuarios entity);
    Boolean delete(String id);
    Usuarios getById(String id);
}
