package com.Societe.ProjetFinalGroupe3.metier;
import java.util.ArrayList;
/*
 * Une oeuvre peut �tre imprim�e sur plusieurs livre, un livre raconte une oeuvre
 * Une oeuvre peut �tre r�serv�e par plusieurs adh�rents, un adh�rent peut r�server plusieurs oeuvres
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class Oeuvre 
{

@Id@GeneratedValue(strategy=GenerationType.AUTO)
private long idOeuvre;
private int compteur;
private String isbn;
private String titre;
private int nbLivreLibre;

@JsonIgnore
@OneToMany(mappedBy="idOA.oeuvre")
private List<OeuvreAdherent> oeuvreAdherent = new ArrayList<OeuvreAdherent>();

@JsonIgnore
@OneToMany(mappedBy="loeuvre")
private Set<Livre> livres = new HashSet<Livre>();



@ManyToOne
private Auteur lauteur;



public Oeuvre() {
	super();
	// TODO Auto-generated constructor stub
}
/*
 *(Table de jointure)
 *Le mappedBy prend id dans OeuvreAdherent
 * private OeuvreAdherentId id;
 */

public List<OeuvreAdherent> getOeuvreAdherent() {
	return oeuvreAdherent;
}
public void setOeuvreAdherent(List<OeuvreAdherent> oeuvreAdherent) {
	this.oeuvreAdherent = oeuvreAdherent;
}
public long getIdOeuvre() {
	return idOeuvre;
}
public void setIdOeuvre(long idOeuvre) {
	this.idOeuvre = idOeuvre;
}
public int getCompteur() {
	return compteur;
}
public void setCompteur(int compteur) {
	this.compteur = compteur;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public int getNbLivreLibre() {
	return nbLivreLibre;
}
public void setNbLivreLibre(int nbLivreLibre) {
	this.nbLivreLibre = nbLivreLibre;
}


public Set<Livre> getLivres() {
	return livres;
}
public void setLivres(Set<Livre> livres) {
	this.livres = livres;
}
public Auteur getLauteur() {
	return lauteur;
}
public void setLauteur(Auteur lauteur) {
	this.lauteur = lauteur;
}

@Override
public String toString() {
	return "Oeuvre [idOeuvre=" + idOeuvre + ", compteur=" + compteur + ", isbn=" + isbn + ", titre=" + titre
			+ ", nbLivreLibre=" + nbLivreLibre + "]";
}
	
	

}
