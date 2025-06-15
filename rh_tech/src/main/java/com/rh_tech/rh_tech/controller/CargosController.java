package com.rh_tech.rh_tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rh_tech.rh_tech.model.CargosModel;
import com.rh_tech.rh_tech.services.CargosServices;


@RestController
@RequestMapping("/cargos")
@CrossOrigin(origins="*")
public class CargosController {
@Autowired
private CargosServices services;

@GetMapping
public List<CargosModel> listarTodos(){
    return services.listarTodos();
}

@GetMapping("/{id}")
public ResponseEntity<CargosModel> buscarId(@PathVariable Long id){
    return services.buscarId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
}

@PostMapping
public CargosModel salvar (@RequestBody CargosModel CargosModel){
    return services.salvar(CargosModel);
}

@PutMapping("/{id}")
public ResponseEntity<CargosModel>atualizar(@PathVariable Long id, @RequestBody CargosModel CargosModel){
    if (!services.buscarId(id).isPresent()) {
        return ResponseEntity.notFound().build();
    }
    CargosModel.setId(id);
    return ResponseEntity.ok(services.salvar(CargosModel));
}

@DeleteMapping("/{id}")
public ResponseEntity<Void>deletar(@PathVariable Long id){
    if (!services.buscarId(id).isPresent()) {
        return ResponseEntity.notFound().build();
    }
    services.deletar(id);
    return ResponseEntity.noContent().build();
}
}
