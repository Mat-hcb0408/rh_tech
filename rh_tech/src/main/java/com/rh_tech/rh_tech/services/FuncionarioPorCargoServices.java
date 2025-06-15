package com.rh_tech.rh_tech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh_tech.rh_tech.model.FuncionarioPorCargoModel;
import com.rh_tech.rh_tech.repository.FuncionarioPorCargoRepository;

@Service
public class FuncionarioPorCargoServices {
@Autowired
private FuncionarioPorCargoRepository repository;

public List<FuncionarioPorCargoModel> listarTodos(){
    return repository.findAll();
}

public Optional<FuncionarioPorCargoModel> buscarId(Long id){
    return repository.findById(id);
}

public FuncionarioPorCargoModel salvar(FuncionarioPorCargoModel vinculo){
    return repository.save(vinculo);
}

public void deletar(Long id){
    repository.deleteById(id);
}

public List<FuncionarioPorCargoModel> filtrarPorCargo(Long cargoId){
    return repository.findByCargoId(cargoId);
}
public List<FuncionarioPorCargoModel> filtrarPorFuncionario(Long funcionarioId){
    return repository.findByFuncionarioId(funcionarioId);
}

}
