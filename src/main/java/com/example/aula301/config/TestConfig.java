package com.example.aula301.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.aula301.entities.Utilisateur;
import com.example.aula301.repositories.UtilisateurRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public void run(String... args) throws Exception {
		Utilisateur u1 = new Utilisateur(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Utilisateur u2 = new Utilisateur(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		utilisateurRepository.saveAll(Arrays.asList(u1, u2));
		
	}

}
