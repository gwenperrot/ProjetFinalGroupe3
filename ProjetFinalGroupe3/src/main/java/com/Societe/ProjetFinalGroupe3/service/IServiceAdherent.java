package com.Societe.ProjetFinalGroupe3.service;

import java.util.List;

import com.Societe.ProjetFinalGroupe3.dao.AdherentDAO;
import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Auteur;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.LivreAdherent;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;

public interface IServiceAdherent {

		public void createAdherent(Adherent ad );
		public void updateAdherent(Adherent ad);
		public Adherent getAdherent(long idAdherent);
		List<Adherent> findAllAdherent();
		public void deleteAdherent(long idAdherent);
		
		public List<Oeuvre> rechercherParMC(String mc);
		public List<Oeuvre> rechercherParAuteur(Oeuvre o);
		public List<Oeuvre> rechercheParOeuvre(Oeuvre o );
		
		public void emprunter (Livre l , Adherent ad);
		public void reserver (Oeuvre o , Adherent ad);
		public void retour(Livre l, Adherent ad);
		void setAdherentDAO(AdherentDAO adherentDAO);
		public List<Oeuvre> findByTitre(String titre);
		
	}


