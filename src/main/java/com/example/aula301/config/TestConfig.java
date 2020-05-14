package com.example.aula301.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.aula301.entities.Categorie;
import com.example.aula301.entities.Commande;
import com.example.aula301.entities.Produit;
import com.example.aula301.entities.Utilisateur;
import com.example.aula301.entities.enums.StatutDeLaCommande;
import com.example.aula301.repositories.CategorieRepository;
import com.example.aula301.repositories.CommandeRepository;
import com.example.aula301.repositories.ProduitRepository;
import com.example.aula301.repositories.UtilisateurRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private ProduitRepository produitRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categorie cat1 = new Categorie(null, "Electronique");
		Categorie cat2 = new Categorie(null, "Livres");
		Categorie cat3 = new Categorie(null, "Ordinateurs");
		categorieRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Produit p1 = new Produit(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produit p2 = new Produit(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produit p3 = new Produit(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produit p4 = new Produit(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produit p5 = new Produit(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		produitRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		Utilisateur u1 = new Utilisateur(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Utilisateur u2 = new Utilisateur(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		utilisateurRepository.saveAll(Arrays.asList(u1, u2));
		
		Commande o1 = new Commande(null, Instant.parse("2019-06-20T19:53:07Z"), StatutDeLaCommande.PAYE, u1);
		Commande o2 = new Commande(null, Instant.parse("2019-07-21T03:42:10Z"), StatutDeLaCommande.EN_ATTENTE_DE_PAIEMENT, u2);
		Commande o3 = new Commande(null, Instant.parse("2019-07-22T15:21:22Z"), StatutDeLaCommande.EN_ATTENTE_DE_PAIEMENT, u1);
		commandeRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}

}
