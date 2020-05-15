package com.example.aula301.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.aula301.entities.enums.StatutDeLaCommande;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_commande") // Cette ligne n'est applicable que lors de l'utilisation de noms réservés par le système ou pour redéfinir le nom uniquement dans la base de données.
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer statutDeLaCommande;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Utilisateur client;
	
	@OneToMany(mappedBy = "id.commande")
	private Set<ArticleDeCommande> articles = new HashSet<>();
	
	@OneToOne(mappedBy = "commande", cascade = CascadeType.ALL)
	private Paiement paiement;
	
	public Commande() {
	}

	public Commande(Long id, Instant moment, StatutDeLaCommande statutDeLaCommande, Utilisateur client) {
		super();
		this.id = id;
		this.moment = moment;
		setStatutDeLaCommande(statutDeLaCommande);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public StatutDeLaCommande getStatutDeLaCommande() {
		return StatutDeLaCommande.valueOf(statutDeLaCommande);
	}

	public void setStatutDeLaCommande(StatutDeLaCommande statutDeLaCommande) {
		if (statutDeLaCommande != null) {
			this.statutDeLaCommande = statutDeLaCommande.getCode();
		}
	}

	public Utilisateur getClient() {
		return client;
	}

	public void setClient(Utilisateur client) {
		this.client = client;
	}
	
	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public Set<ArticleDeCommande> getArticles() {
		return articles;
	}
	
	public Double getTotal() {
		double somme = 0.0;
		for(ArticleDeCommande x : articles) {
			somme += x.getSousTotal();
		}
		return somme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
