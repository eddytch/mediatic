package dao;

import model.Utilisateur;

public class UtilisateurDAO extends GenericDAO<Utilisateur> {

	private static UtilisateurDAO dao;

	public UtilisateurDAO() {
		super(Utilisateur.class);
	}

	public static UtilisateurDAO instance() {
		if (dao == null) {
			dao = new UtilisateurDAO();
		}
		return dao;
	}
}