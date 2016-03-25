package dao;

import model.Adresse;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AdresseDAO extends GenericDAO<Adresse> {
	
	private static AdresseDAO adresseDAO;
	
	public AdresseDAO() {
		super(Adresse.class);
        debutReq+=" Adresse adr " ;
	}
	
	public static AdresseDAO instance() {
		if (adresseDAO == null) {
			adresseDAO = new AdresseDAO();
		}
		return adresseDAO;
	}

	public List<Adresse> findWithObject(Adresse uneAdresse){
        // On cree un entityManager
        EntityManager entityManager = DatabaseHelper.createEntityManager();
        // La requete apres le WHERE
        String req = "" ;
        // Dans la suite on ajoute dans les if ce qu'on doit ajoute à la requete SQL pour filtrer sur un champ precis
        // Si l adresse contient un nom de rue
        if (uneAdresse.getNomRue() != null)
            req += (" adr.nomRue = :nomRue AND");
        // Si l adresse contient un numero de rue
        if (uneAdresse.getNumRue() != null)
            req += (" adr.numRue =:numRue AND") ;
        // Si l adresse contient un code postal
        if (uneAdresse.getCpVille() != null)
            req +=(" adr.cpVille = :cpVille AND") ;
        // Si l adresse contient une ville
        if(uneAdresse.getVille() != null)
            req +=(" adr.ville = :ville AND") ;
        // Si l adresse contient un pays
        if(uneAdresse.getPays() != null)
            req +=(" adr.pays = :pays AND") ;

        // On construit la requete
        req = buildRequest(req) ;

        Query uneReq = entityManager.createQuery(req) ;

        /*
         * Dans la suite dans les if, on ajoute la valeur des parametres correspondant à la valeur du champ de l'objet
         * passe en parametre
         */
        // Si l adresse contient un nom de rue
        if (uneAdresse.getNomRue() != null)
            uneReq.setParameter("nomRue", uneAdresse.getNomRue()) ;
        // Si l'adresse contient un numero de rue
        if (uneAdresse.getNumRue() != null)
            uneReq.setParameter("numRue", uneAdresse.getNumRue()) ;
        // Si l adresse contient un code postal
        if (uneAdresse.getCpVille() != null)
            uneReq.setParameter("cpVille", uneAdresse.getCpVille()) ;
        // Si l adresse contient une ville
        if(uneAdresse.getVille() != null)
            uneReq.setParameter("ville", uneAdresse.getVille()) ;
        // Si l adresse contient un pays
        if(uneAdresse.getPays() != null)
            uneReq.setParameter("pays", uneAdresse.getPays()) ;

        // On recupere la liste des adresses
        return uneReq.getResultList() ;
    }
}
