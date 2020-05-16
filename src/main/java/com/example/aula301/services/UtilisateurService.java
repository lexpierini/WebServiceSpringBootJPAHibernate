package com.example.aula301.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula301.entities.Utilisateur;
import com.example.aula301.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository repository;
	
	public List<Utilisateur> findAll() {
		return repository.findAll();
	}
	
	public Utilisateur findById(Long id) {
		Optional<Utilisateur> obj = repository.findById(id);
		return obj.get();
	}
	
	public Utilisateur insert(Utilisateur obj) {
		return repository.save(obj);
	}

}
