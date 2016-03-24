package model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by utilisateur on 23/03/2016.
 */
@Entity
public class Media {

    public enum Type {Livre,CD,DVD}

    @Id
    @GeneratedValue
    private long id ;

    @Column
	@NotEmpty
    private String titre ;

	@NotNull
    @Enumerated(EnumType.STRING)
    private Type type ;

	@NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Auteur auteurMedia ;

	@OneToMany(mappedBy = "mediaLoue")
	private List<Emprunt> mediaEmprunte;

    public Media(){

    }

    public Media(String titre, Auteur auteurMedia, Type type) {
        this.titre = titre;
        this.auteurMedia = auteurMedia;
        this.type = type;
    }

	/**
	 * Affichage client
	 */
	public String toString() {
		return "Media (id =" + getId() + "," + getTitre() + "," + getType() + "," + getAuteurMedia()  + ")";
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

    public Auteur getAuteurMedia() {
        return auteurMedia;
    }

    public void setAuteurMedia(Auteur auteurMedia) {
        this.auteurMedia = auteurMedia;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Emprunt> getMediaEmprunte() {
		return mediaEmprunte;
	}

	public void setMediaEmprunte(List<Emprunt> mediaEmprunte) {
		this.mediaEmprunte = mediaEmprunte;
	}
}
