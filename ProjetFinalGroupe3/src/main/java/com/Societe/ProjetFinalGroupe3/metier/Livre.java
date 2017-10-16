
package com.Societe.ProjetFinalGroupe3.metier;
/*
 * La classe livre r�pertorie tous les livres de la biblioth�que (libre ou non)
 * Jointures : une oeuvre peut �tre imprim�e sur plusieurs livre, un livre raconte une oeuvre
 * 				un livre peut �tre emprunt�s par plusieurs adh�rents, un adh�rent peut emprunt� plusieurs livres
 * 
 */

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Component
@Entity
public class Livre {

@Id@GeneratedValue(strategy=GenerationType.AUTO)
private Long idLivre;
private int numInventaire;
private boolean dispo ;

@JsonIgnore
@OneToMany(mappedBy="idLA.livre")
private List<LivreAdherent> livreAdherent;

@ManyToOne
private Oeuvre loeuvre;


public Livre() {
	super();
	// TODO Auto-generated constructor stub
}

public List<LivreAdherent> getLivreAdherent() {
	return livreAdherent;
}
public void setLivreAdherent(List<LivreAdherent> livreAdherent) {
	this.livreAdherent = livreAdherent;
}

public Long getIdLivre() {
	return idLivre;
}
public void setIdLivre(Long idLivre) {
	this.idLivre = idLivre;
}
public int getNumInventaire() {
	return numInventaire;
}
public void setNumInventaire(int numInventaire) {
	this.numInventaire = numInventaire;
}

public boolean isDispo() {
	return dispo;
}

public void setDispo(boolean dispo) {
	this.dispo = dispo;
}

public Oeuvre getLoeuvre() {
	return loeuvre;
}
public void setLoeuvre(Oeuvre loeuvre) {
	this.loeuvre = loeuvre;
}

@Override
public String toString() {
	return "Livre [idLivre=" + idLivre + ", numInventaire=" + numInventaire + ", dispo=" + dispo + "]";
}


}
