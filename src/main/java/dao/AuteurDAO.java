package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Auteur;

/**
 * Created by utilisateur on 23/03/2016.
 */
public class AuteurDAO extends GenericDAO<Auteur> {

    private static AuteurDAO dao;

    public AuteurDAO() {
        super(Auteur.class);
        debutReq+=" Auteur aut " ;
    }

    public static AuteurDAO instance() {
        if (dao == null) {
            dao = new AuteurDAO();
        }
        return dao;

    }

    public List<Auteur> findWithObject(Auteur auteur){
        //On crée un entityManager
        EntityManager entityManager = DatabaseHelper.createEntityManager();
        // La requete après le WHERE
        String req = "" ;
        // Si l'objet auteur contient un nom
        if (auteur.getNom() != null)
            req += (" aut.nom = :nom AND");
        // Si l'objet auteur contient un prenom
        if (auteur.getPrenom() != null)
            req += (" aut.prenom =:prenom AND") ;

        // On construit la requete
        req = buildRequest(req) ;

        // On cree la requete
        TypedQuery<Auteur> uneReq = entityManager.createQuery(req,Auteur.class) ;

        //Dans la suite on ajoute les parametres de la requete
        // Si l'auteur contient un nom
        if (auteur.getNom() != null)
            uneReq.setParameter("nom", auteur.getNom()) ;
        // Si l'auteur contient un prenom
        if (auteur.getPrenom() != null)
            uneReq.setParameter("prenom", auteur.getPrenom()) ;

        // On recupere la liste des auteurs
        return uneReq.getResultList() ;
    }
}