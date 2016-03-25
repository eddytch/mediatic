package dao;

import model.Adherent;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AdherentDAO extends GenericDAO<Adherent> {
	
	private static AdherentDAO adherentDAO;
	
	public AdherentDAO() {
		super(Adherent.class);
        debutReq+=" Adherent adh" ;
	}
	
	public static AdherentDAO instance() {
		if (adherentDAO == null) {
			adherentDAO = new AdherentDAO();
		}
		return adherentDAO;
	}

    public List<Adherent> findWithObject(Adherent adherent){
        // On cree un entityManager
        EntityManager entityManager = DatabaseHelper.createEntityManager();
        // La requete apres le WHERE
        String req = "" ;
        // Dans la suite on ajoute dans les if ce qu'on doit ajoute à la requete SQL pour filtrer sur un champ precis
        // Si l adhrent contient un nom
        if (adherent.getNom() != null)
            req += (" adh.nom = :nom AND");
        // Si l adherent contient un prenom
        if (adherent.getPrenom() != null)
            req += (" adh.prenom = :prenom AND") ;
        // Si l adherent contient un email
        if (adherent.getEmail() != null)
            req +=(" adh.email = :email AND") ;

        // On construit la chaine de la requete
        req = buildRequest(req) ;

        // On crée la requete
        TypedQuery<Adherent> uneReq = entityManager.createQuery(req,Adherent.class) ;

        /*
         * Dans la suite dans les if, on ajoute la valeur des parametres correspondant à la valeur du champ de l'objet
         * passe en parametre
         */
        // Si l adherent contient un nom
        if (adherent.getNom() != null)
            uneReq.setParameter("nom", adherent.getNom()) ;
        // Si l'adherent a un prenom
        if (adherent.getPrenom() != null)
            uneReq.setParameter("prenom", adherent.getPrenom()) ;
        // Si l adherent contient un email
        if (adherent.getEmail() != null)
            uneReq.setParameter("email", adherent.getEmail()) ;

        // On recupere la liste des adherents
        return uneReq.getResultList() ;
    }
}
