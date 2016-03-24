package model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Utilisateur {
	
    @Id
    @GeneratedValue
	private Long id;
	@NotEmpty
	private String login;
	@NotEmpty
	private String mdp;
	
	public Utilisateur(){
		
	}
	
	public Utilisateur(String login, String mdp) {
		this.login = login;
		this.mdp = mdp;
	}
	
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id =id;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
