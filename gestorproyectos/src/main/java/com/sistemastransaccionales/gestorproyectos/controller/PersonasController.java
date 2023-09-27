package com.sistemastransaccionales.gestorproyectos.controller;

import com.sistemastransaccionales.gestorproyectos.dto.Personas;
import com.sistemastransaccionales.gestorproyectos.message.ResponseMessage;
import com.sistemastransaccionales.gestorproyectos.services.PersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PersonasController {

    @Autowired
    private PersonasService service;
    @PostMapping("/personas/createorupdate")
    public ResponseEntity<ResponseMessage<Personas>> CreateOrUpdate(@RequestBody Personas entity)throws Exception {
        Personas result;
        try {
            result = service.insert(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, "Guardado con exito", result));
    }

    @PostMapping("/personas/updateproyecto")
    public ResponseEntity<ResponseMessage<Personas>> addaproyecto(@RequestBody Personas entity)throws Exception {
        Personas result;
        try {
            result = service.updateproyecto(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, "Guardado con exito", result));
    }

    @GetMapping("/personas/getall")
    public ResponseEntity<ResponseMessage<List<Personas>>> GetAll(){
        List<Personas> result = service.getAll();
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }

    @DeleteMapping("/personas/delete/{id}")
    public ResponseEntity<ResponseMessage<Boolean>> Delete(@PathVariable(value = "id")String id){
        Boolean result = service.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }

    @PostMapping("/personas/getbyid")
    public ResponseEntity<ResponseMessage<Personas>> GetAll(@RequestBody String id){
        Personas result = service.getById(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }

    @PostMapping("/personas/getproyectobypersona")
    public ResponseEntity<ResponseMessage<List<Map<String, Object>>>> GETDATABYPERSONA(@RequestBody String id){
        List<Map<String, Object>> result = service.getdatabypersona(id);
        System.out.println(result);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }

    @PostMapping("/personas/getintegrantes")
    public ResponseEntity<ResponseMessage<List<Personas>>> GETINTEGRANTES(@RequestBody String id){
        List<Personas> result = service.getintegrantesproyecto(id);
        System.out.println(result);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }
}
