package com.Societe.ProjetFinalGroupe3.service;

import java.util.List;

import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Auteur;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.LivreAdherent;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;
import com.Societe.ProjetFinalGroupe3.metier.OeuvreAdherent;
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
	
	public void emprunter(Oeuvre o, Livre l, Adherent ad);
	public void reserver(Oeuvre o, Adherent ad);
	public void retour(Long idLivre, Long idAdherent);
	public Utilisateur rechercheByLogin(String login);
	public Oeuvre getOeuvre(long idOeuvre);
	
	public List<LivreAdherent> findAllEmprunt();
	public List<LivreAdherent> findByIdAdherent(long idAdherent);
	
	public List<OeuvreAdherent> findAllResa();
	public List<OeuvreAdherent> findResaByIdAdherent(long idAdherent);
	public void annulation(Long idOeuvre, Long idAdherent);
	
}
