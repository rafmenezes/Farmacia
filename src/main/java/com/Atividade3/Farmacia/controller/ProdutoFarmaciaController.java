package com.Atividade3.Farmacia.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Atividade3.Farmacia.model.ProdutoFarmacia;
import com.Atividade3.Farmacia.repository.ProdutoFarmaciaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produtofar")
public class ProdutoFarmaciaController 
{

	 @Autowired
	 private ProdutoFarmaciaRepository repository;
	 
	 
	 @GetMapping
	 public ResponseEntity<List<ProdutoFarmacia>> getAll()
	 {
		 return	ResponseEntity.ok(repository.findAll());
	 }
	 @GetMapping("/{id}")
	 public ResponseEntity<ProdutoFarmacia> getById(@PathVariable long id)
	 {
		 return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				 .orElse(ResponseEntity.notFound().build());
	 }
	 
	 @GetMapping("/medicamento/{medicamento}")
	 public ResponseEntity<List<ProdutoFarmacia>> getByMedicamento(@PathVariable String medicamento)
	 {
		 return ResponseEntity.ok(repository.findAllByMedicamentoContainingIgnoreCase(medicamento));
	 }
	 
	 @PostMapping
	 public ResponseEntity<ProdutoFarmacia> post (@RequestBody ProdutoFarmacia produtofarmacia)
	 {
		 return ResponseEntity.status(HttpStatus.CREATED)
				 .body(repository.save(produtofarmacia));	 
	 }
	 
	 @PutMapping
	 public ResponseEntity<ProdutoFarmacia> put (@RequestBody ProdutoFarmacia produtofarmacia)
	 {
		 return ResponseEntity.ok(repository.save(produtofarmacia));
				 
	 }
	 
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable long id)
	 {
		 repository.deleteById(id);
	 }
}
