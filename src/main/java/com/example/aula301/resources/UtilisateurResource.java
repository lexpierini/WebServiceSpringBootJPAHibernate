package com.example.aula301.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula301.entities.Utilisateur;
import com.example.aula301.services.UtilisateurService;

@RestController
@RequestMapping(value = "/utilisateurs")
public class UtilisateurResource {
	
	@Autowired
	private UtilisateurService service;
	
	@GetMapping
	public ResponseEntity<List<Utilisateur>> findAll() {
		List<Utilisateur> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Utilisateur> findById(@PathVariable Long id) {
		Utilisateur obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
