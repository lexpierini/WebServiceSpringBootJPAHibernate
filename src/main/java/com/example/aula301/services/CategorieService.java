package com.example.aula301.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula301.entities.Categorie;
import com.example.aula301.repositories.CategorieRepository;

@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepository repository;
	
	public List<Categorie> findAll() {
		return repository.findAll();
	}
	
	public Categorie findById(Long id) {
		Optional<Categorie> obj = repository.findById(id);
		return obj.get();
	}

}
