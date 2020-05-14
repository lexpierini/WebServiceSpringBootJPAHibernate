package com.example.aula301.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula301.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
