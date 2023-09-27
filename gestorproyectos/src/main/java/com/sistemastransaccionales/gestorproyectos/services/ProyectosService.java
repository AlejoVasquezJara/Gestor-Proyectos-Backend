package com.sistemastransaccionales.gestorproyectos.services;

import com.sistemastransaccionales.gestorproyectos.dto.Proyectos;

import java.text.ParseException;
import java.util.List;

public interface ProyectosService {
    List<Proyectos> getAll();
    Proyectos getById(String id);
    Proyectos insertorupdate(Proyectos entity) throws ParseException;
    Boolean delete(String id);
}
