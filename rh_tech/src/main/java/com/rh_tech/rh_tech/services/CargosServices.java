package com.rh_tech.rh_tech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh_tech.rh_tech.model.CargosModel;
import com.rh_tech.rh_tech.repository.CargosRepository;

@Service
public class CargosServices {
@Autowired
private CargosRepository repository;

public List<CargosModel> listarTodos(){
    return repository.findAll();
}

public Optional<CargosModel> buscarId(Long id){
    return repository.findById(id);
}

public CargosModel salvar(CargosModel cargosModel){
    return repository.save(cargosModel);
}

public void deletar(Long id){
    repository.deleteById(id);
}

}
