package com.Societe.ProjetFinalGroupe3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Societe.ProjetFinalGroupe3.dao.AdherentDAO;
import com.Societe.ProjetFinalGroupe3.dao.LivreDAO;
import com.Societe.ProjetFinalGroupe3.dao.OeuvreDAO;
import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Auteur;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;
@Service
public class ServiceAdherentImpl implements IServiceAdherent {
	@Autowired
	AdherentDAO adherentDAO;
	@Autowired
	LivreDAO livreDAO;
	@Autowired
	OeuvreDAO oeuvreDAO;

	
	
	
	public LivreDAO getLivreDAO() {
		return livreDAO;
	}


	public void setLivreDAO(LivreDAO livreDAO) {
		this.livreDAO = livreDAO;
	}


	public OeuvreDAO getOeuvreDAO() {
		return oeuvreDAO;
	}


	public void setOeuvreDAO(OeuvreDAO oeuvreDAO) {
		this.oeuvreDAO = oeuvreDAO;
	}


	public void setAdherentDAO(AdherentDAO adherentDAO) {
		this.adherentDAO = adherentDAO;
	}
	

	public AdherentDAO getAdherentDAO() {
		return adherentDAO;
	}
	
	/*CRUD Adherent*/
	
	@Override
	public void createAdherent(Adherent ad) {
			adherentDAO.save(ad);
	}

	@Override
	public void updateAdherent(Adherent ad) {
			adherentDAO.saveAndFlush(ad);
	}
	
	@Override
	public Adherent getAdherent(long idUtilisateur) {
		return adherentDAO.findById(idUtilisateur).get();
	}

	@Override
	public List<Adherent> findAllAdherent() {
		return adherentDAO.findAll();
	}
	
	@Override
	public void deleteAdherent(long idUtilisateur) {
		adherentDAO.deleteById(idUtilisateur);
	}

	/*Methodes de recherche des livres/oeuvre pour les adherents*/
	@Override
	public List<Livre> rechercherParMC(String mc) {
		return  livreDAO.rechercherParMC(mc+"%");
	}

	@Override
	public List<Oeuvre> rechercherParAuteur(Oeuvre o) {
		return oeuvreDAO.rechercheParAuteur(o);
	}


	@Override
	public List<Oeuvre> rechercheParOeuvre(Oeuvre o) {
		return oeuvreDAO.rechercherParOeuvre(o);
	}

	/*Methode d'emprunt et de reservation de livres*/
	
	@Override
	public void emprunter(Livre l , Adherent ad) {
		//adherentDAO.emprunter(l,ad);
	}

	@Override
	public void reserver(Oeuvre o, Adherent ad) {
		//adherentDAO.reserver(o,ad);
	}

}
