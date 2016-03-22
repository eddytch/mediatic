package dao;

import model.Auteur;

/**
 * Created by utilisateur on 23/03/2016.
 */
public class AuteurDAO extends GenericDAO<Auteur> {

    private static AuteurDAO dao;

    public AuteurDAO() {
        super(Auteur.class);
    }

    public static AuteurDAO instance() {
        if (dao == null) {
            dao = new AuteurDAO();
        }
        return dao;
    }
}