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

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateNce() {
		return dateNce;
	}

	public void setDateNce(Date dateNce) {
		this.dateNce = dateNce;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Date getDateFinCotisation() {
		return dateFinCotisation;
	}

	public void setDateFinCotisation(Date dateFinCotisation) {
		this.dateFinCotisation = dateFinCotisation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	// Fin Getters & Setters

}
