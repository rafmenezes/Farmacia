package com.Atividade3.Farmacia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categoria")
public class Categoria 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;


@NotNull
@Size(min = 5, max = 30)
private String titulo;

@NotNull
@Size(min = 2, max = 15)
private String remedio;

@NotNull
@Size(min = 5, max = 100)
private String descricao;

@Temporal(TemporalType.TIMESTAMP)
private Date data = new java.sql.Date(System.currentTimeMillis());

@ManyToOne
@JsonIgnoreProperties("categoria")
private ProdutoFarmacia produtofarmacia;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getRemedio() {
	return remedio;
}

public void setRemedio(String remedio) {
	this.remedio = remedio;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public Date getData() {
	return data;
}

public void setData(Date data) {
	this.data = data;
}

public ProdutoFarmacia getProdutofarmacia() {
	return produtofarmacia;
}

public void setProdutofarmacia(ProdutoFarmacia produtofarmacia) {
	this.produtofarmacia = produtofarmacia;
}



}
