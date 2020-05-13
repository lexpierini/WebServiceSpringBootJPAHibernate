package com.example.aula301.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula301.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
