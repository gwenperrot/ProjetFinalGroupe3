package com.Societe.ProjetFinalGroupe3.metier;
/*
 * La classe adherent herite d'Utilisateur, l'adh�rent va pouvoir s'enregister, s'authentifier
 * consulter la liste des oeuvres, r�server une oeuvre, emprunter un livre et g�rer son compte
 * 
 * Niveau relation : un Adh�rent peut emprunter plusieurs livres et un livre peut �tre emprunt� par plusieurs adh�rents
 * 					 un adh�rent peut r�server plusieurs oeuvres et une oeuvre peut �tre emprunt�e par des adh�rents
 */
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
@DiscriminatorValue("Adherent") 
public class Adherent extends Utilisateur{

	private String nom;
	private String prenom;
	private String numTel;
	private Date dateIns;
	private String Ville;
	private int codePostal;
	
	@OneToMany(mappedBy="idOA.adherent")
	private List<OeuvreAdherent> adherentOeuvre;
	@OneToMany(mappedBy="idLA.adherent")
	private List<LivreAdherent> adherentLivre;
	

	
	public List<LivreAdherent> getAdherentLivre() {
		return adherentLivre;
	}


	public void setAdherentLivre(List<LivreAdherent> adherentLivre) {
		this.adherentLivre = adherentLivre;
	}



	public List<OeuvreAdherent> getAdherentOeuvre() {
		return adherentOeuvre;
	}
	
	
	public void setAdherentOeuvre(List<OeuvreAdherent> adherentOeuvre) {
		this.adherentOeuvre = adherentOeuvre;
	}
	
	public Adherent() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public Date getDateIns() {
		return dateIns;
	}
	public void setDateIns(Date dateIns) {
		this.dateIns = dateIns;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	

	@Override
	public String toString() {
		return "Adherent [ nom=" + nom + ", prenom=" + prenom + ", numTel=" + numTel + ", dateIns="
				+ dateIns + ", Ville=" + Ville + ", codePostal=" + codePostal + "]";
	}
	
	
}
