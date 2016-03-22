package model;

import java.util.Date;

public class Adherent {
	
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private Date dateNce;
	private Date datePaiement;
	private Date dateFinCotisation; // A voir le client si on garde 
	private double montant;
	
	public Adherent() {
		
	}

	public Adherent(String nom, String prenom, String email, Date dateNce, Date datePaiement, Date dateFinCotisation, double montant) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNce = dateNce;
		this.datePaiement = datePaiement;
		this.dateFinCotisation = dateFinCotisation;
		this.montant = montant;
	}

}
