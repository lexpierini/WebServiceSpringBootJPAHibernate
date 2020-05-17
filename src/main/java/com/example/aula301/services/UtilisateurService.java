package com.example.aula301.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.aula301.entities.Utilisateur;
import com.example.aula301.repositories.UtilisateurRepository;
import com.example.aula301.services.exceptions.DatabaseException;
import com.example.aula301.services.exceptions.ResourceNotFoundException;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository repository;
	
	public List<Utilisateur> findAll() {
		return repository.findAll();
	}
	
	public Utilisateur findById(Long id) {
		Optional<Utilisateur> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Utilisateur insert(Utilisateur obj) {
		return repository.save(obj);
	}
	  
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public Utilisateur update(Long id, Utilisateur obj) {
		try {
			Utilisateur entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Utilisateur entity, Utilisateur obj) {
		entity.setNom(obj.getNom());
		entity.setCourriel(obj.getCourriel());
		entity.setTelephone(obj.getTelephone());
	}

}
