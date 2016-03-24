package main;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AdherentDAO;
import dao.EmpruntDAO;
import dao.MediaDAO;
import dao.UtilisateurDAO;
import model.Adherent;
import model.Adresse;
import model.Auteur;
import model.Emprunt;
import model.Media;
import model.Media.Type;
import model.Utilisateur;

/**
 * Created by utilisateur on 22/03/2016.
 */
public class MediaticMain {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) {

        // Création List Adhérent & Adresse
    	AdherentDAO adherentDAO = new AdherentDAO();
    	
    	List<Adherent> adherents = new ArrayList<Adherent>();
    	
    	adherents.add(new Adherent("TCH", "Eddy", "thc@gmail.com", new Date(1980, 01, 01), (new Adresse("20", "Rue des Maraîchers", "75020", "Paris", "FRANCE")), new Date(2015, 12, 31), 50.00 ));
    	adherents.add(new Adherent("LANOE", "Dimitri", "dimi@gmail.com", new Date(1992, 10, 22), (new Adresse("3","rue nomaffiche","35400","Saint-Malo","FRANCE")), new Date(2015, 10, 10), 22.10 ));
    	adherents.add(new Adherent("JACQUET", "Louis", "louis@gmail.com", new Date(1990, 11, 12), (new Adresse("27", "Rue de la basse carotte", "76230", "LE HAUT POIRIER", "FRANCE")), new Date(2016, 01, 31), 25.50 ));
    	adherents.add(new Adherent("MARTIN", "Adrien", "adrien@gmail.com", new Date(1991, 04, 01), (new Adresse("10", "Rue de la Beaugoire", "44000", "Paris", "FRANCE")), new Date(2015, 12, 31), 50.00 ));
    	adherents.add(new Adherent("ALI", "Zino", "zino@gmail.com", new Date(1987, 01, 01), (new Adresse("1", "Place des lices", "35000", "Rennes", "FRANCE")), new Date(2015, 12, 31), 10.00 ));
    	adherents.add(new Adherent("CBM", "Chancy", "cbm@gmail.com", new Date(1990, 01, 01), (new Adresse("20", "Rue des Maraîchers", "75020", "Paris", "FRANCE")), new Date(2015, 12, 31), 50.00 ));
    	adherents.add(new Adherent("MJ", "Jeremy", "mj@gmail.com", new Date(1980, 01, 01), (new Adresse("20", "Rue des Maraîchers", "75020", "Paris", "FRANCE")), new Date(2015, 12, 31),  50.00 ));
    	adherents.add(new Adherent("RK", "Rebacca", "rk@gmail.com", new Date(1980, 01, 01), (new Adresse("20", "Rue des Maraîchers", "75020", "Paris", "FRANCE")), new Date(2015, 12, 31), 50.00 ));
    	adherents.add(new Adherent("TCH", "Jack", "jack@gmail.com", new Date(1980, 01, 01), (new Adresse("20", "Rue des Maraîchers", "75020", "Paris", "FRANCE")), new Date(2015, 12, 31), 50.00 ));
    	adherents.add(new Adherent("CBM", "Eddy", "lol@gmail.com", new Date(1980, 01, 01), (new Adresse("20", "Rue des Maraîchers", "75020", "Paris", "FRANCE")), new Date(2015, 12, 31),  50.00 ));

        // Parcours de tous les adhérents pour l'ajouter en BD
    	for (Adherent adh : adherents) {
			adherentDAO.persist(adh);
		}

        // Création List Media & Auteur
        MediaDAO mediaDAO = new MediaDAO();
        
        List<Media> medias = new ArrayList<Media>();
        
        // Ajout es Media & Auteur dans la liste
        medias.add(new Media("UML 2 par la pratique: Etudes de cas et exercices corrigés", (new Auteur("Roques", "Pascal")), Type.Livre ));
        medias.add(new Media("Programmer en Java : Couvre les nouveautés de Java 8, streams, expressions lambda", (new Auteur("Delannoy", "Claude")), Type.Livre ));
        medias.add(new Media("Pro AngularJS", (new Auteur("Freeman", "Adam")), Type.Livre ));
        medias.add(new Media("Legend", (new Auteur("Bob", "Marley")), Type.CD ));
        medias.add(new Media("Listen", (new Auteur("David", "Guetta")), Type.CD ));
        medias.add(new Media("Mon Cur avait Raison", (new Auteur("Maîtres", "Gims")), Type.CD ));
        medias.add(new Media("Seul contre tous", (new Auteur("Will", "Smith")), Type.DVD ));
        medias.add(new Media("The revenant", (new Auteur("Leonardo", "DiCaprio")), Type.DVD ));
        medias.add(new Media("Célibataire, mode d'emploi", (new Auteur("Dakota", "Johnson")), Type.DVD ));
        medias.add(new Media("JBoss par la pratique: Etudes de cas et exercices corrigés", (new Auteur("Lanoe"," Dimitri")), Type.Livre ));
        
        // Parcours de tous les médias pour l'ajouter en BD
        for (Media m : medias) {
			mediaDAO.persist(m);
		}

        // Ajout user en BD
        UtilisateurDAO userDAO = new UtilisateurDAO();
        
        List<Utilisateur> users = new ArrayList<Utilisateur>();
        
        users.add(new Utilisateur("root", "mdp"));
        users.add(new Utilisateur("eddy", "eddy"));
        users.add(new Utilisateur("dimi", "dimi"));
        users.add(new Utilisateur("louis", "louis"));
        
        for (Utilisateur user : users) {
        	userDAO.persist(user);
		}        
        
        // Création Emprunt
        EmpruntDAO empruntDAO = new EmpruntDAO();
        
        List<Emprunt> emprunts = new ArrayList<Emprunt>();
        emprunts.add(new Emprunt(new Date(2016,03,25), medias.get(0), adherents.get(0)));
        emprunts.add(new Emprunt(new Date(2015,12,25), medias.get(1), adherents.get(1)));
        emprunts.add(new Emprunt(new Date(2016,01,01), medias.get(2), adherents.get(2)));
        emprunts.add(new Emprunt(new Date(2015,03,25), medias.get(3), adherents.get(3)));
        emprunts.add(new Emprunt(new Date(2016,03,25), medias.get(4), adherents.get(4)));
        emprunts.add(new Emprunt(new Date(2016,03,25), medias.get(5), adherents.get(5)));
        emprunts.add(new Emprunt(new Date(2016,03,25), medias.get(6), adherents.get(6)));
        emprunts.add(new Emprunt(new Date(2016,03,25), medias.get(7), adherents.get(7)));
        emprunts.add(new Emprunt(new Date(2016,03,25), medias.get(8), adherents.get(8)));
        emprunts.add(new Emprunt(new Date(2016,03,25), medias.get(9), adherents.get(9)));
        
        for (Emprunt e : emprunts) {
 			empruntDAO.persist(e);
 		}     

    }

}
