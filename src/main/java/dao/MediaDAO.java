package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Auteur;
import model.Media;

/**
 * Created by utilisateur on 23/03/2016.
 */
public class MediaDAO extends GenericDAO<Media> {

    private static MediaDAO dao;

    public MediaDAO() {
        super(Media.class);
        debutReq+=" Media med " ;
    }

    public static MediaDAO instance() {
        if (dao == null) {
            dao = new MediaDAO();
        }
        return dao;
    }

    public List<Media> findWithObject(Media media){

        //On crée un entityManager
        EntityManager entityManager = DatabaseHelper.createEntityManager();
        // La requete après le WHERE
        String req = "" ;
        // On initialise une liste vide d'auteurs
        List<Auteur> auteurs = new ArrayList<Auteur>() ;
        //Si l'objet media contient un auteur
        if (media.getAuteurMedia() != null) {
            //On récupère la liste des auteurs filtrés avec l'auteur qui est dans le media
            auteurs = AuteurDAO.instance().findWithObject(media.getAuteurMedia());
        }
        //Si l'objet contient un titre
        if (media.getTitre() != null)
            req += (" med.titre = :titre AND");
        //Si l'objet contient un type
        if (media.getType() != null)
            req += (" med.type = :type AND") ;


        // On recupere la requete
        req = buildRequest(req) ;

        System.out.println("req = " + req);
        //On cree la requete
        TypedQuery<Media> uneReq = entityManager.createQuery(req,Media.class) ;

        //Si le media contient un titre on filtre avec le titre dans la requete
        if (media.getTitre() != null) {
            uneReq.setParameter("titre", media.getTitre()) ;
        }
        //Si le media contient un type on filtre avec le type dans la requete
        if (media.getType() != null) {
            uneReq.setParameter("type", media.getType().toString()) ;
        }

        // On requete la liste des medias avec la requetes
        
        List<Media> listeMedias = uneReq.getResultList();
        //Si l'objet media contient un auteur
        if(media.getAuteurMedia() != null) {


            // Pour chaque medias
            for (int i = 0; i < listeMedias.size(); i++) {
                Media unMedia = listeMedias.get(i);
                // On regarde si le media n'a pas un auteur dans la liste des auteurs sur lesquels on a filtre
                if (!auteurs.contains(unMedia.getAuteurMedia())) {
                    // Dans le cas ou on a un auteur dans media qui n'est pas dans la liste des auteurs on le supprime
                    listeMedias.remove(listeMedias.get(i));
                    // On decremente la position (car on a supprime un element)
                    i--;
                }
            }
        }

        //On retourne la liste des medias
        return  listeMedias;
    }
}
