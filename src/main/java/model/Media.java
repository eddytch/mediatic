package model;

import javax.persistence.*;

/**
 * Created by utilisateur on 23/03/2016.
 */
public class Media {

    @Id
    @GeneratedValue
    private long id ;

    @Column
    private String titre ;

    @Enumerated(EnumType.STRING)
    private Type type ;

    public enum Type {Livre,CD,DVD}

    public Media(){

    }

    public Media(String titre, Type type) {
        this.titre = titre;
        this.type = type;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
