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
	
	private long jourEnMS(int jour) {
		return jour * 86400000;// 24*60*60*1000
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
	
	

	public void setDateFinLocation() {
		if (this.getDateEmprunt() != null) {

			long finLoc = this.getDateEmprunt().getTime();

			switch (this.mediaLoue.getType()) {
			case Livre:
				finLoc += jourEnMS(30);
				break;
			case CD:
			case DVD:
			default:
				finLoc += jourEnMS(15);
				break;
			}
			this.dateFinLocation = new Date(finLoc);
		} else {
			this.dateFinLocation = null;
		}
	}

	public void setDateMediaRendu(Date dateMediaRendu) {
		this.dateMediaRendu = dateMediaRendu;
	}

}