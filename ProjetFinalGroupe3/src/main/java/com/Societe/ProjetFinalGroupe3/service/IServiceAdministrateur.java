package com.Societe.ProjetFinalGroupe3.service;

import java.util.List;

import com.Societe.ProjetFinalGroupe3.dao.AdministrateurDAO;
import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Auteur;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;

public interface IServiceAdministrateur {
		public void createAuteur(Auteur a );
		public void updateAuteur(Auteur a);
		public Auteur getAuteur(long idAuteur);
		List<Auteur> findAllAuteur();
		public void deleteAuteur(long idAuteur);
		
		public void createAdherent(Adherent ad );
		public void updateAdherent(Adherent ad);
		public Adherent getAdherent(long idAdherent);
		List<Adherent> findAllAdherent();
		public void deleteAdherent(long idAdherent);
		
		public void createOeuvre(Oeuvre o );
		public void updateOeuvre(Oeuvre o);
		public Oeuvre getOeuvre(long idOeuvre);
		List<Oeuvre> findAllOeuvre();
		public void deleteOeuvre(long idOeuvre);
		
		public void createLivre(Livre l );
		public void updateLivre(Livre l);
		public Livre getLivre(long idLivre);
		List<Livre> findAllLivre();
		public void deleteLivre(long idLivre);
		
		public List<Livre> rechercherParMC(String mc);
		public List<Oeuvre> rechercherParAuteur(Oeuvre o);
		public List<Oeuvre> rechercheParOeuvre(Oeuvre o );
		public List<Adherent> rechercherParId(long idAdherent);
		
	}


