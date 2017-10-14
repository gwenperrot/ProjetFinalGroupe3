package com.Societe.ProjetFinalGroupe3.metier;
/*
 * La classe m�re Utilisateur est la classe dont h�rite administrateur et adherent.
 * Le but : facilit� l'authentification 
 * choix de la m�thode d'h�ritage : single table. 
 */
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.stereotype.Component;

@Component
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_Utilisateur")
@DiscriminatorValue("PERSONNE")
public class Utilisateur {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUtilisateur;
	private String login;
	private String mdp;
	
	
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", login=" + login + ", mdp=" + mdp + "]";
	}
	
	

}
