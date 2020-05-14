package com.example.aula301.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.aula301.entities.pk.ArticleDeCommandePK;

@Entity
@Table(name = "tb_article_de_commande")
public class ArticleDeCommande implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ArticleDeCommandePK id;
	private Integer quantite;
	private Double prix;
	
	public ArticleDeCommande() {
	}

	public ArticleDeCommande(Commande commande, Produit produit, Integer quantite, Double prix) {
		super();
		id.setCommande(commande);
		id.setProduit(produit);
		this.quantite = quantite;
		this.prix = prix;
	}
	
	public Commande getCommande() {
		return id.getCommande();
	}
	
	public void setCommande(Commande commande) {
		id.setCommande(commande);
	}
	
	public Produit getProduit() {
		return id.getProduit();
	}
	
	public void setProduit(Produit produit) {
		
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
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
		ArticleDeCommande other = (ArticleDeCommande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
