package br.edu.ifspcjo.ads.dw2a6.TIF.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name ="forma_pagamento")
public class FormaPagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@NotNull
	@OneToOne
	@JoinColumn(name = "ordem_servico_id")
	private OrdemServiço ordemServiço;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OrdemServiço getOrdemServiço() {
		return ordemServiço;
	}
	public void setOrdemServiço(OrdemServiço ordemServiço) {
		this.ordemServiço = ordemServiço;
	}
	
}
