package com.example.aula301.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula301.entities.Commande;
import com.example.aula301.repositories.CommandeRepository;

@Service
public class CommandeService {
	
	@Autowired
	private CommandeRepository repository;
	
	public List<Commande> findAll() {
		return repository.findAll();
	}
	
	public Commande findById(Long id) {
		Optional<Commande> obj = repository.findById(id);
		return obj.get();
	}

}
