package com.example.aula301.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula301.entities.Produit;
import com.example.aula301.repositories.ProduitRepository;

@Service
public class ProduitService {
	
	@Autowired
	private ProduitRepository repository;
	
	public List<Produit> findAll() {
		return repository.findAll();
	}
	
	public Produit findById(Long id) {
		Optional<Produit> obj = repository.findById(id);
		return obj.get();
	}

}
