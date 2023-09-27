package com.sistemastransaccionales.gestorproyectos.dao;

import com.sistemastransaccionales.gestorproyectos.dto.Personas;


import java.util.List;
import java.util.Map;

public interface PersonasDAO {

    List<Personas> getAll();
    Personas getById(String id);
    List<Map<String, Object>> getdatabypersona(String id);
    List<Personas> getintegrantesproyecto(String id);
    Personas insert(Personas entity);
    Personas update(Personas entity);
    Personas updateproyecto(Personas entity);
    Boolean delete(String id);
}
