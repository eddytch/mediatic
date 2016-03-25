package main;


import dao.*;
import model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by utilisateur on 22/03/2016.
 */
public class MediaticMain {

    public static void main(String[] args) {

        /*
         * Un premier adherent avec son adresse
         */
        Adherent adherent1 = new Adherent("dimitri","lanoe","dimitrilanoe35@gmail.com",new Date(1992,10,22),new Date(2015,10,10), new Date(2016,10,10),22.10) ;
        Adresse adr1 = new Adresse("3","rue nomaffiche","35400","Saint-Malo","France") ;
        AdresseDAO adresseDAO = AdresseDAO.instance() ;
        adresseDAO.persist(adr1) ;
        adherent1.setAdresse(adr1);
        AdherentDAO.instance().persist(adherent1) ;

        /*
         * Un premier media avec son auteur
         */
        Media media1 = new Media("un essai xyz ", Media.Type.Livre) ;
        Auteur auteur1 = new Auteur("tamisier","clement") ;
        AuteurDAO.instance().persist(auteur1) ;
        media1.setAuteurMedia(auteur1);
        MediaDAO.instance().persist(media1) ;

        /*
         * Un utilisateur de l'applications
         */
        Utilisateur util1 = new Utilisateur("root","mdp") ;
        UtilisateurDAO.instance().persist(util1) ;

        /*
         * Un emprunt est realise par adherent1 sur media1 le 25 mars 2016
         */
        Emprunt emprunt1 = new Emprunt(new Date(2016,03,25)) ;
        emprunt1.setLoueur(adherent1);
        emprunt1.setMediaLoue(media1);
        EmpruntDAO.instance().persist(emprunt1) ;

    }

}
