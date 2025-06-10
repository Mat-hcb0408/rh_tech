package com.rh_tech.rh_tech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh_tech.rh_tech.model.FuncionariosModel;
import com.rh_tech.rh_tech.repository.FuncionariosRepository;

@Service
public class FuncionariosServices {
@Autowired
private FuncionariosRepository repository;

public List<FuncionariosModel> listarTodos(){
    return repository.findAll();
}

public Optional<FuncionariosModel> buscarId(Long id){
    return repository.findById(id);
}

public FuncionariosModel salvar(FuncionariosModel funcionariosModel){
    return repository.save(funcionariosModel);
}

public void deletar(Long id){
    repository.deleteById(id);
}

}
