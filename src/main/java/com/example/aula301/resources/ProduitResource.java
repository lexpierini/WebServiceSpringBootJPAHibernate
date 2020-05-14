package com.example.aula301.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula301.entities.Produit;
import com.example.aula301.services.ProduitService;

@RestController
@RequestMapping(value = "/produits")
public class ProduitResource {
	
	@Autowired
	private ProduitService service;
	
	@GetMapping
	public ResponseEntity<List<Produit>> findAll() {
		List<Produit> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produit> findById(@PathVariable Long id) {
		Produit obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
