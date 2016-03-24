package model;

import java.util.List;

import javax.persistence.*;

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

	@NotEmpty
    @Enumerated(EnumType.STRING)
    private Type type ;

	@NotEmpty
    @ManyToOne
    private Auteur auteurMedia ;

	@OneToMany(mappedBy = "mediaLoue")
	private List<Emprunt> mediaEmprunte;

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
