package com.sistemastransaccionales.gestorproyectos.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Personas {
    private String idunicpersona;
    private String idproyecto;
    private String dsnombre;
    private LocalDateTime fenacimiento;
    private String role;
}
