package com.Societe.ProjetFinalGroupe3.metier;
/*
 * La classe Auteur a une relation avec oeuvre : un auteur peut �crire plusieurs oeuvres,
 *  et une oeuvre est �crite par un auteur
 */
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class Auteur {

@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private long idAuteur;
	private String nom;
	private String prenom;
	
	
	
	public Auteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="lauteur")
	private Set<Oeuvre> OeuvresAuteur = new HashSet<Oeuvre>();

	public Long getIdAuteur() {
		return idAuteur;
	}
	public void setIdAuteur(long idAuteur) {
		this.idAuteur = idAuteur;
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
	
	public Set<Oeuvre> getOeuvresAuteur() {
		return OeuvresAuteur;
	}
	public void setOeuvresAuteur(Set<Oeuvre> oeuvresAuteur) {
		OeuvresAuteur = oeuvresAuteur;
	}
	@Override
	public String toString() {
		return "Auteur [idAuteur=" + idAuteur + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
}
