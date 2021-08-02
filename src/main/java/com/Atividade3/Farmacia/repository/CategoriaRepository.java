package com.Atividade3.Farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Atividade3.Farmacia.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long>
{
	public List<Categoria> findAllByRemedioContainingIgnoreCase (String Remedio);
}
