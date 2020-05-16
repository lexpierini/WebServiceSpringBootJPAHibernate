package com.example.aula301.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Utilisateur> insert(@RequestBody Utilisateur obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
