package com.Atividade3.Farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtoFarmacia")
public class ProdutoFarmacia 
{
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@NotNull
private String medicamento;


@OneToMany(mappedBy = "produtofarmacia", cascade = CascadeType.ALL)
@JsonIgnoreProperties("produtofarmacia")
private List <Categoria> categoria;



public long getId() {
	return id;
}



public void setId(long id) {
	this.id = id;
}



public String getMedicamento() {
	return medicamento;
}



public void setMedicamento(String medicamento) {
	this.medicamento = medicamento;
}



public List<Categoria> getCategoria() {
	return categoria;
}



public void setCategoria(List<Categoria> categoria) {
	this.categoria = categoria;
}






}


