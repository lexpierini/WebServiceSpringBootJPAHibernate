package com.example.aula301.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula301.entities.Categorie;
import com.example.aula301.services.CategorieService;

@RestController
@RequestMapping(value = "/categories")
public class CategorieResource {
	
	@Autowired
	private CategorieService service;
	
	@GetMapping
	public ResponseEntity<List<Categorie>> findAll() {
		List<Categorie> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categorie> findById(@PathVariable Long id) {
		Categorie obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
