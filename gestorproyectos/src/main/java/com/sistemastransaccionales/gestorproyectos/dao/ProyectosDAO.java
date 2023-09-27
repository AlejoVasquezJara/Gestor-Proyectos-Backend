package com.sistemastransaccionales.gestorproyectos.dao;

import com.sistemastransaccionales.gestorproyectos.dto.Proyectos;

import java.util.List;
import java.util.Map;

public interface ProyectosDAO {
    List<Proyectos> getAll();
    Proyectos getById(String id);
    Proyectos insert(Proyectos entity);
    Proyectos update(Proyectos entity);
    Boolean delete(String id);
}
