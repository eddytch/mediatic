package model;

import java.util.Date;

import javax.persistence.ManyToOne;

public class Emprunt {
	
	private Date dateEmprunt;
	
	@ManyToOne
	private Media mediaLoue;
	
	@ManyToOne
	private Adherent loueur;

//	@OneTOMany(mappedBy = "mediaLoue")
//	private List<Emprunt> mediaEmprunte;
	
//	@OneTOMany(mappedBy = "loueur")
//	private List<Emprunt> adherentEmprunteur;
	
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
}