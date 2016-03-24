package dao;

import model.Adherent;

public class AdherentDAO extends GenericDAO<Adherent> {
	
	private static AdherentDAO adherentDAO;
	
	public AdherentDAO() {
		super(Adherent.class);
	}
	
	public static AdherentDAO instance() {
		if (adherentDAO == null) {
			adherentDAO = new AdherentDAO();
		}
		return adherentDAO;
	}

}
