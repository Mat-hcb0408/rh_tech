package com.rh_tech.rh_tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rh_tech.rh_tech.model.CargosModel;

@Repository
public interface CargosRepository extends JpaRepository<CargosModel,Long>{}
