package com.example.aula301.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula301.entities.Utilisateur;

@RestController
@RequestMapping(value = "/utilisateurs")
public class UtilisateurResource {
	
	@GetMapping
	public ResponseEntity<Utilisateur> findAll() {
		Utilisateur u = new Utilisateur(1L, "Maria", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u);
	}

}
