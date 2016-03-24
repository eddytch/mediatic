package main;

import dao.AdherentDAO;
import dao.AdresseDAO;
import dao.AuteurDAO;
import dao.MediaDAO;
import model.Adherent;
import model.Adresse;
import model.Auteur;
import model.Media;

import java.util.List;

/**
 * Created by utilisateur on 25/03/2016.
 */
public class FindWithObjectMain {

    public static void main(String[] args) {

        MediaticMain.main(null);

        Adresse adresse = new Adresse() ;
        adresse.setNumRue("20"); ;
        List<Adresse> adresses = AdresseDAO.instance().findWithObject(adresse) ;
        for (Adresse adress : adresses) {
            System.out.println("adress = " + adress);
        }

        Auteur auteur = new Auteur() ;
        auteur.setPrenom("Guetta");
        List<Auteur> auteurs = AuteurDAO.instance().findWithObject(auteur) ;
        for (Auteur unAuteur : auteurs) {
            System.out.println("unAuteur = " + unAuteur);
        }

        Media media = new Media() ;
        media.setAuteurMedia(auteur);
        List<Media> medias = MediaDAO.instance().findWithObject(media) ;
        for (Media unMedia : medias) {
            System.out.println("unMedia = " + unMedia);
        }

        Adherent adh = new Adherent() ;
        adh.setPrenom("Dimitri");
        List<Adherent> adherents = AdherentDAO.instance().findWithObject(adh) ;
        for (Adherent adherent : adherents ){
            System.out.println(adherent);
        }
    }
}
