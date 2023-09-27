package com.sistemastransaccionales.gestorproyectos.controller;

import com.sistemastransaccionales.gestorproyectos.dto.Usuarios;
import com.sistemastransaccionales.gestorproyectos.message.ResponseMessage;
import com.sistemastransaccionales.gestorproyectos.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuariosController {
    @Autowired
    private UsuariosService service;
    @PostMapping("/usuarios/register")
    public ResponseEntity<ResponseMessage<Usuarios>> CreateOrUpdate(@RequestBody Usuarios entity)throws Exception {
        Usuarios result;
        try {
            result = service.insert(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, "Guardado con exito", result));
    }

    @GetMapping("/usuarios/getall")
    public ResponseEntity<ResponseMessage<List<Usuarios>>> GetAll(){
        List<Usuarios> result = service.getAll();
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }

    @DeleteMapping("/usuarios/delete/{id}")
    public ResponseEntity<ResponseMessage<Boolean>> Delete(@PathVariable(value = "id")String id){
        //Se borran los planes de pago
        Boolean result = service.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }

    @PostMapping("/usuarios/login")
    public ResponseEntity<ResponseMessage<Usuarios>> GetData(@RequestBody Usuarios entity){
        Usuarios result = service.getByinfo(entity);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }
}
