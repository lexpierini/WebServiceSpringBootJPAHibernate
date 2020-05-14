package com.example.aula301.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula301.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
