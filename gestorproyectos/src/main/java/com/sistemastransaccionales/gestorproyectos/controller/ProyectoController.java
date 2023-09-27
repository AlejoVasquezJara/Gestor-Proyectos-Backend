package com.sistemastransaccionales.gestorproyectos.controller;

import com.sistemastransaccionales.gestorproyectos.dto.Proyectos;
import com.sistemastransaccionales.gestorproyectos.message.ResponseMessage;
import com.sistemastransaccionales.gestorproyectos.services.ProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProyectoController {
    @Autowired
    private ProyectosService service;
    @PostMapping("/proyectos/createorupdate")
    public ResponseEntity<ResponseMessage<Proyectos>> CreateOrUpdate(@RequestBody Proyectos entity)throws Exception {
        Proyectos result;
        try {
            result = service.insertorupdate(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, "Guardado con exito", result));
    }

    @GetMapping("/proyectos/getall")
    public ResponseEntity<ResponseMessage<List<Proyectos>>> GetAll(){
        List<Proyectos> result = service.getAll();
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }

    @DeleteMapping("/proyectos/delete/{id}")
    public ResponseEntity<ResponseMessage<Boolean>> Delete(@PathVariable(value = "id")String id){
        //Se borran los planes de pago
        Boolean result = service.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }


}
