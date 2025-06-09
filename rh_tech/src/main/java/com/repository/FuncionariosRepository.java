package com.rh_tech.rh_tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.FuncionariosModel;

@Repository
public interface FuncionariosRepository extends JpaRepository<FuncionariosModel,Long>{}
