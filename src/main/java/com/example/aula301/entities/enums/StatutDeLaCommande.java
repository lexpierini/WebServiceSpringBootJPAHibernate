package com.example.aula301.entities.enums;

public enum StatutDeLaCommande {
	EN_ATTENTE_DE_PAIEMENT(1),
	PAYE(2),
	EXPEDIE(3),
	LIVRE(4),
	ANNULE(5);
	
	private int code;
	
	private StatutDeLaCommande(int code) {
		this.code = code;
	}
	
	public int getCode() { 
		return code;
	}
	
	public static StatutDeLaCommande valueOf(int code) {
		for (StatutDeLaCommande value : StatutDeLaCommande.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Code StatutDeLaCommande non valide.");
	}
}
