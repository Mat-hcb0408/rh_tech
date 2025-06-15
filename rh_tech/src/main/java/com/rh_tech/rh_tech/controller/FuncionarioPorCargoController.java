package com.rh_tech.rh_tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rh_tech.rh_tech.model.FuncionarioPorCargoModel;
import com.rh_tech.rh_tech.services.FuncionarioPorCargoServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/funcionario-por-cargo")
@CrossOrigin(origins="*")
public class FuncionarioPorCargoController {
@Autowired
private FuncionarioPorCargoServices services;

@GetMapping
public List<FuncionarioPorCargoModel> listarTodos(@RequestParam(required=false) Long cargoId, @RequestParam(required=false) Long funcionarioId){
if (cargoId != null) {
    return services.filtrarPorCargo(cargoId);
}else if (funcionarioId != null) {
    return services.filtrarPorCargo(funcionarioId);
}else{
    return listarTodos(cargoId, funcionarioId);
}
}

@GetMapping("/{id}")
public ResponseEntity <FuncionarioPorCargoModel> buscarId(@PathVariable Long id){
    Optional<FuncionarioPorCargoModel> vinculo=services.buscarId(id);
    return vinculo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
}

@PostMapping
public FuncionarioPorCargoModel salvar(@RequestBody FuncionarioPorCargoModel vinculo){
    return services.salvar(vinculo);
}

@PutMapping("/{id}")
public ResponseEntity<FuncionarioPorCargoModel> atualizar(@PathVariable Long id, @RequestBody FuncionarioPorCargoModel vinculo){
    if (!services.buscarId(id).isPresent()) {
        return ResponseEntity.notFound().build();
    }
    vinculo.setId(id);
    return ResponseEntity.ok(services.salvar(vinculo));
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deletar(@PathVariable long id){
    if (!services.buscarId(id).isPresent()) {
        return ResponseEntity.notFound().build();
    }
    services.deletar(id);
    return ResponseEntity.noContent().build();
}
}
