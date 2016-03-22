package dao;

import model.Emprunt;

public class EmpruntDAO extends GenericDAO<Emprunt> {

	private static EmpruntDAO dao;

	public EmpruntDAO() {
		super(Emprunt.class);
	}

	public static EmpruntDAO instance() {
		if (dao == null) {
			dao = new EmpruntDAO();
		}
		return dao;
	}
}