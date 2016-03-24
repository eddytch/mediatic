package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.Transient;

@Entity
public class Emprunt {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private Date dateEmprunt;
	
	@ManyToOne
	private Media mediaLoue;
	
	@Transient
	private Date dateFinLocation;
	
	private Date dateMediaRendu;
	
	@ManyToOne
	private Adherent loueur;
	
	public Emprunt(){
		
	}
	
	public Emprunt(Date dateEmprunt, Media mediaLoue, Adherent loueur) {
		this.dateEmprunt = dateEmprunt;
		this.mediaLoue = mediaLoue;
		this.loueur = loueur;
	}

	/**
	 * Affichage client
	 */
	public String toString() {
		return "Emprunt (id =" + getId() + "," + getDateEmprunt() + "," + getMediaLoue() + "," + getLoueur()  + ")";
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

	public Date getDateMediaRendu() {
		return dateMediaRendu;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateFinLocation() {
		return dateFinLocation;
	}
	
	

	@SuppressWarnings("deprecation")
	public void setDateFinLocation() {
		if (this.getDateEmprunt() != null) {

			int year = this.getDateEmprunt().getYear();
			int month = this.getDateEmprunt().getMonth();
			int day = this.getDateEmprunt().getDay();

			switch (this.mediaLoue.getType()) {
			case Livre:
				day += 30;
				break;
			case CD:
			case DVD:
			default:
				day += 15;
				break;
			}
			this.dateFinLocation = new Date(year, month, day);
		} else {
			this.dateFinLocation = null;
		}
	}

	public void setDateMediaRendu(Date dateMediaRendu) {
		this.dateMediaRendu = dateMediaRendu;
	}

}