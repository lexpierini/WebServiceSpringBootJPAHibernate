package com.example.aula301.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula301.entities.ArticleDeCommande;

public interface ArticleDeCommandeRepository extends JpaRepository<ArticleDeCommande, Long> {

}
