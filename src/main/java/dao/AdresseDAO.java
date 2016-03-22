package dao;

import model.Adresse;

public class AdresseDAO extends GenericDAO<Adresse> {
	
	private static AdresseDAO adresseDAO;
	
	public AdresseDAO() {
		super(Adresse.class);
	}
	
	public static AdresseDAO instance() {
		if (adresseDAO == null) {
			adresseDAO = new AdresseDAO();
		}
		return adresseDAO;
	}
}
