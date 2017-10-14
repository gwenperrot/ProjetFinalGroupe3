package com.Societe.ProjetFinalGroupe3.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

/*
 * Administrateur : celui qui va g�re les livres, controle les emprunts, les r�servations et les utlisateurs du logiciel
 */
@Component
@Entity
@DiscriminatorValue("Administrateur") 
public class Administrateur extends Utilisateur {

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

}



