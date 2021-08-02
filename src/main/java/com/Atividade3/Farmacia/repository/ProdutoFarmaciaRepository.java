package com.Atividade3.Farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Atividade3.Farmacia.model.ProdutoFarmacia;

public interface ProdutoFarmaciaRepository extends JpaRepository <ProdutoFarmacia, Long>
{
  public List<ProdutoFarmacia> findAllByMedicamentoContainingIgnoreCase(String Medicamento);
}
