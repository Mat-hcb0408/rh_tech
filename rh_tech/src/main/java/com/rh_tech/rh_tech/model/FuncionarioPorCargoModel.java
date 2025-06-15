package com.rh_tech.rh_tech.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="funcionario_por_cargo")
@Getter
@Setter
@NoArgsConstructor

public class FuncionarioPorCargoModel {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name="funcionario_id", nullable=false)
private FuncionariosModel funcionarioId;

@ManyToOne
@JoinColumn(name="cargo_id",nullable=false)
private CargosModel cargoId;

@Column
private String detalhes;

@Column(nullable=false)
private LocalDate data_inicio;

@Column
private LocalDate data_fim;
}
