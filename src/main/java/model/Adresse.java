package model;

public class Adresse {
	
	private Long id;
	private String numRue;
	private String nomRue;
	private int cpVille;
	private String ville;
	private String pays;
	
	public Adresse() {
		
	}

	public Adresse(String numRue, String nomRue, int cpVille, String ville, String pays) {
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.cpVille = cpVille;
		this.ville = ville;
		this.pays = pays;
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

	public int getCpVille() {
		return cpVille;
	}

	public void setCpVille(int cpVille) {
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
	// Fin Getters & Setters

}
