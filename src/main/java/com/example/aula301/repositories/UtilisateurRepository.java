package com.example.aula301.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula301.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
