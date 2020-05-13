package com.example.aula301.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula301.entities.Commande;
import com.example.aula301.services.CommandeService;

@RestController
@RequestMapping(value = "/commandes")
public class CommandeResource {
	
	@Autowired
	private CommandeService service;
	
	@GetMapping
	public ResponseEntity<List<Commande>> findAll() {
		List<Commande> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Commande> findById(@PathVariable Long id) {
		Commande obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
