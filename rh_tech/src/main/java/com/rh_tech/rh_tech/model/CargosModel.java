package com.rh_tech.rh_tech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cargos")
@Getter
@Setter

@NoArgsConstructor
public class CargosModel {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;

@Column(nullable=false)
private String nome;

@Column(nullable=false)
private String descricao;
}
