package com.sistemastransaccionales.gestorproyectos.services;

import com.sistemastransaccionales.gestorproyectos.dto.Personas;

import java.util.List;
import java.util.Map;
//Molde en el que basare mi implementacion
public interface PersonasService {

    List<Personas> getAll();
    Personas getById(String id);
    Personas insert(Personas entity);
    Boolean delete(String id);
    List<Map<String, Object>> getdatabypersona(String id);
    List<Personas> getintegrantesproyecto(String id);
    Personas updateproyecto(Personas entity);

}
