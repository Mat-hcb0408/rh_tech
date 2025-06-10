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

import com.rh_tech.rh_tech.model.FuncionariosModel;
import com.rh_tech.rh_tech.services.FuncionariosServices;


@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class FuncionariosController {
@Autowired
private FuncionariosServices services;

@GetMapping
public List<FuncionariosModel> listarTodos(){
    return services.listarTodos();
}

@GetMapping("/{id}")
public ResponseEntity<FuncionariosModel> buscarId(@PathVariable Long id){
    return services.buscarId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
}

@PostMapping
public FuncionariosModel salvar (@RequestBody FuncionariosModel funcionariosModel){
    return services.salvar(funcionariosModel);
}

@PutMapping("/{id}")
public ResponseEntity<FuncionariosModel>atualizar(@PathVariable Long id, @RequestBody FuncionariosModel funcionariosModel){
    if (services.buscarId(id).isPresent()) {
        return ResponseEntity.notFound().build();
    }
    funcionariosModel.setId(id);
    return ResponseEntity.ok(services.salvar(funcionariosModel));
}

@DeleteMapping("/{id}")
public ResponseEntity<Void>deletar(@PathVariable Long id){
    if (services.buscarId(id).isPresent()) {
        return ResponseEntity.notFound().build();
    }
    services.deletar(id);
    return ResponseEntity.noContent().build();
}
}
