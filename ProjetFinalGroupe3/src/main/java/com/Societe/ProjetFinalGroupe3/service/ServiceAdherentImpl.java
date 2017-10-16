package com.Societe.ProjetFinalGroupe3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Societe.ProjetFinalGroupe3.dao.AdherentDAO;
import com.Societe.ProjetFinalGroupe3.dao.LivreAdherentDAO;
import com.Societe.ProjetFinalGroupe3.dao.LivreDAO;
import com.Societe.ProjetFinalGroupe3.dao.OeuvreAdherentDAO;
import com.Societe.ProjetFinalGroupe3.dao.OeuvreDAO;
import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Auteur;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.LivreAdherent;
import com.Societe.ProjetFinalGroupe3.metier.LivreAdherentId;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;
import com.Societe.ProjetFinalGroupe3.metier.OeuvreAdherent;
@Service
public class ServiceAdherentImpl implements IServiceAdherent {
	@Autowired
	AdherentDAO adherentDAO;
	@Autowired
	LivreDAO livreDAO;
	@Autowired
	OeuvreDAO oeuvreDAO;
	@Autowired
	LivreAdherentDAO livreAdherentDAO;
	@Autowired
	OeuvreAdherentDAO oeuvreAdherentDAO;
	
	
	
	
	
	public OeuvreAdherentDAO getOeuvreAdherentDAO() {
		return oeuvreAdherentDAO;
	}


	public void setOeuvreAdherentDAO(OeuvreAdherentDAO oeuvreAdherentDAO) {
		this.oeuvreAdherentDAO = oeuvreAdherentDAO;
	}


	public LivreAdherentDAO getLivreAdherentDAO() {
		return livreAdherentDAO;
	}


	public void setLivreAdherentDAO(LivreAdherentDAO livreAdherentDAO) {
		this.livreAdherentDAO = livreAdherentDAO;
	}


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
	public List<Oeuvre> rechercherParMC(String mc) {
		return  oeuvreDAO.rechercherParMC(mc+"%");
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
		LivreAdherent la = new LivreAdherent(l, ad);
		livreAdherentDAO.save(la);	
	}
	
	@Override
	public void reserver(Oeuvre o, Adherent ad) {
		OeuvreAdherent oa = new OeuvreAdherent(o, ad);
		oeuvreAdherentDAO.save(oa);
	}


	@Override
	public void retour (Livre l, Adherent ad) {
		LivreAdherent la = new LivreAdherent(l, ad);
		livreAdherentDAO.delete(la);;
		
	}


	@Override
	public List<Oeuvre> findByTitre(String titre) {
		// TODO Auto-generated method stub
		return oeuvreDAO.findByTitre(titre);
	}
	

}
