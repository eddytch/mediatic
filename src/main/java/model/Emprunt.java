package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Emprunt {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Date dateEmprunt;
	
	@ManyToOne
	private Media mediaLoue;
	
	@ManyToOne
	private Adherent loueur;
	
	public Emprunt(){
		
	}

	public Emprunt(Date dateEmprunt) {
		super();
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}


	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Media getMediaLoue() {
		return mediaLoue;
	}

	public void setMediaLoue(Media mediaLoue) {
		this.mediaLoue = mediaLoue;
	}

	public Adherent getLoueur() {
		return loueur;
	}

	public void setLoueur(Adherent loueur) {
		this.loueur = loueur;
	}
}