package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Adresse {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	private String numRue;
	@NotEmpty
	private String nomRue;
	@NotEmpty
	private String cpVille;
	@NotEmpty
	private String ville;
	@NotEmpty
	private String pays;
	
	@OneToMany(mappedBy = "adresse")
	private List<Adherent> adherents;
	
	public Adresse() {
		
	}

	public Adresse(String numRue, String nomRue, String cpVille, String ville, String pays) {
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.cpVille = cpVille;
		this.ville = ville;
		this.pays = pays;
	}

	/**
	 * Affichage client
	 */
	public String toString() {
		return "Adresse (id =" + getId() + "," + getNumRue() + "," + getNomRue() + "," + getCpVille() + "," + getCpVille() + ")";
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumRue() {
		return numRue;
	}

	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getCpVille() {
		return cpVille;
	}

	public void setCpVille(String cpVille) {
		this.cpVille = cpVille;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public List<Adherent> getAdherents() {
		return adherents;
	}

	public void setAdherents(List<Adherent> adherents) {
		this.adherents = adherents;
	}
	// Fin Getters & Setters

}
