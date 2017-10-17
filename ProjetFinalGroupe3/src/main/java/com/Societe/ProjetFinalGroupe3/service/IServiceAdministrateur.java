package com.Societe.ProjetFinalGroupe3.service;

import java.util.List;

import com.Societe.ProjetFinalGroupe3.dao.AdministrateurDAO;
import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Auteur;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;
import com.Societe.ProjetFinalGroupe3.metier.Utilisateur;

public interface IServiceAdministrateur {
		public Auteur createAuteur(Auteur a );
		public Auteur updateAuteur(Auteur a);
		public Auteur getAuteur(long idAuteur);
		List<Auteur> findAllAuteur();
		public void deleteAuteur(long idAuteur);
		
		public Adherent createAdherent(Adherent ad );
		public Adherent updateAdherent(Adherent ad);
		public Adherent getAdherent(long idAdherent);
		List<Adherent> findAllAdherent();
		public void deleteAdherent(long idAdherent);
		
		public Oeuvre createOeuvre(Oeuvre o );
		public Oeuvre updateOeuvre(Oeuvre o);
		public Oeuvre getOeuvre(long idOeuvre);
		List<Oeuvre> findAllOeuvre();
		public void deleteOeuvre(long idOeuvre);
		
		public Livre createLivre(Livre l );
		public Livre updateLivre(Livre l);
		public Livre getLivre(long idLivre);
		public List<Livre> findAllLivre();
		public void deleteLivre(long idLivre);
		
		public List<Oeuvre> rechercherParMC(String mc);
		public List<Auteur> rechercherParAuteur(String auteur);
		public List<Oeuvre> rechercheParOeuvre(String oeuvre);
	//	public List<Adherent> rechercherParId(long idAdherent);
		public List<Oeuvre> findByTitre(String titre);
		
		public void attribuerLivreOeuvre(Livre l , Oeuvre o );
		public void attribuerOeuvreAuteur(Oeuvre o, Auteur a);
		public Utilisateur rechercheByLogin (String login);
		public String rechercherType(Utilisateur u);
	}


