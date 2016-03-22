package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Auteur{

    @Id
    @GeneratedValue
    private long id ;

    @Column
    private String nom ;

    @Column
    private String prenom ;

    @OneToMany(mappedBy = "auteurMedia")
    private List<Media> listeMedias ;

    public Auteur(){

    }

    public Auteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Media> getListeMedias() {
        return listeMedias;
    }

    public void setListeMedias(List<Media> listeMedias) {
        this.listeMedias = listeMedias;
    }
}