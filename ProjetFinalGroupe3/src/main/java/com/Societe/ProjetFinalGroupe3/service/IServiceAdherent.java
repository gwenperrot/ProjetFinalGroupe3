package com.Societe.ProjetFinalGroupe3.service;

import java.util.List;

import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Auteur;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;
import com.Societe.ProjetFinalGroupe3.metier.Utilisateur;

public interface IServiceAdherent {

	public void createAdherent(Adherent ad);
	public void updateAdherent(Adherent ad);
	public Adherent getAdherent(long idUtilisateur);
	public List<Adherent> findAllAdherent();
	public void deleteAdherent(long idUtilisateur);
	public List<Oeuvre> rechercherParMC(String mc);
	public List<Auteur> rechercherParAuteur(String a);
	public List<Oeuvre> rechercheParOeuvre(String o);
	public void emprunter(Livre l, Adherent ad);
	public void reserver(Oeuvre o, Adherent ad);
	public void retour(Livre l, Adherent ad);
	public Utilisateur rechercheByLogin(String login);

	
}
