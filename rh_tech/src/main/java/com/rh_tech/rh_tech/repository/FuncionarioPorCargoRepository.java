package com.rh_tech.rh_tech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rh_tech.rh_tech.model.FuncionarioPorCargoModel;
@Repository
public interface FuncionarioPorCargoRepository extends JpaRepository<FuncionarioPorCargoModel, Long>{
    
    List<FuncionarioPorCargoModel> findByCargoId(Long cargoId);
    List<FuncionarioPorCargoModel> findByFuncionarioId(Long funcionarioId);
}
