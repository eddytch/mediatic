package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Adherent {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String nom;
	@NotEmpty
	private String prenom;
	@NotEmpty
	private String email;

	@NotNull
	private Date dateNce;
	private Date datePaiement;
	private double montant;
	@Transient
	private Date dateFinCotisation; // A voir le client si on garde 
	
	@ManyToOne
	private Adresse adresse;
	
	@OneToMany(mappedBy = "loueur")
	private List<Emprunt> adherentEmprunteur;
	
	public Adherent() {
		
	}

	public Adherent(String nom, String prenom, String email, Date dateNce, Date datePaiement, Date dateFinCotisation, double montant) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNce = dateNce;
		this.datePaiement = datePaiement;
		this.montant = montant;
		this.dateFinCotisation = dateFinCotisation;
	}

	/**
	 * Affichage client
	 */
	public String toString() {
		return "Adherent (id =" + getId() + "," + getNom() + "," + getPrenom() + ")";
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Emprunt> getAdherentEmprunteur() {
		return adherentEmprunteur;
	}

	public void setAdherentEmprunteur(List<Emprunt> adherentEmprunteur) {
		this.adherentEmprunteur = adherentEmprunteur;
	}
	// Fin Getters & Setters

}
