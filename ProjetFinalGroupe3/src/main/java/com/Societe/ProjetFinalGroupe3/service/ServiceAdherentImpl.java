package com.Societe.ProjetFinalGroupe3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Societe.ProjetFinalGroupe3.dao.AdherentDAO;
import com.Societe.ProjetFinalGroupe3.dao.AuteurDAO;
import com.Societe.ProjetFinalGroupe3.dao.LivreAdherentDAO;
import com.Societe.ProjetFinalGroupe3.dao.LivreDAO;
import com.Societe.ProjetFinalGroupe3.dao.OeuvreAdherentDAO;
import com.Societe.ProjetFinalGroupe3.dao.OeuvreDAO;
import com.Societe.ProjetFinalGroupe3.dao.UtilisateurDAO;
import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Auteur;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.LivreAdherent;
import com.Societe.ProjetFinalGroupe3.metier.LivreAdherentId;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;
import com.Societe.ProjetFinalGroupe3.metier.OeuvreAdherent;
import com.Societe.ProjetFinalGroupe3.metier.Utilisateur;
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
	@Autowired
	AuteurDAO auteurDAO;
	@Autowired
	UtilisateurDAO utilisateurDAO;
	
	
	
	
	public AuteurDAO getAuteurDAO() {
		return auteurDAO;
	}


	public void setAuteurDAO(AuteurDAO auteurDAO) {
		this.auteurDAO = auteurDAO;
	}


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
	public List<Auteur> rechercherParAuteur(String auteur) {
		return auteurDAO.rechercheParAuteur(auteur);
	}


	@Override
	public List<Oeuvre> rechercheParOeuvre(String o) {
		return oeuvreDAO.rechercherParOeuvre(o);
	}

	/*Methode d'emprunt et de reservation de livres*/
	
	@Override
	public void emprunter(Oeuvre o, Livre l , Adherent ad) {
		LivreAdherent la = new LivreAdherent(l, ad);
		livreAdherentDAO.save(la);	
		livreDAO.saveAndFlush(l);
		oeuvreDAO.saveAndFlush(o);
	}
	
	@Override
	public void reserver(Oeuvre o, Adherent ad) {
		OeuvreAdherent oa = new OeuvreAdherent(o, ad);
		oeuvreAdherentDAO.save(oa);
	}


	@Override
	public void retour (Long idLivre, Long idAdherent) {
		Livre l= livreDAO.getOne(idLivre);
		Adherent ad = adherentDAO.getOne(idAdherent);
		LivreAdherent la = new LivreAdherent(l, ad);
		livreAdherentDAO.delete(la);
		
	}


	@Override
	public Utilisateur rechercheByLogin(String login) {
		return utilisateurDAO.rechercheByLogin(login);
	}


//	@Override
//	public List<Oeuvre> findByTitre(String titre) {
//		// TODO Auto-generated method stub
//		return oeuvreDAO.findByTitre(titre);
//	}
//	

	@Override
	public Oeuvre getOeuvre(long idOeuvre) {
		return 	oeuvreDAO.findById(idOeuvre).get();
	}


	@Override
	public List<LivreAdherent> findAllEmprunt() {
		return livreAdherentDAO.findAll();
	}


	@Override
	public List<LivreAdherent> findByIdAdherent(long idAdherent) {
		
		return livreAdherentDAO.findByAdherent(idAdherent);
	}


	@Override
	public List<OeuvreAdherent> findAllResa() {
		return oeuvreAdherentDAO.findAll();
	}


	@Override
	public void annulation(Long idOeuvre, Long idAdherent) {
		Oeuvre o= oeuvreDAO.getOne(idOeuvre);
		Adherent ad = adherentDAO.getOne(idAdherent);
		OeuvreAdherent oa = new OeuvreAdherent(o, ad);
		oeuvreAdherentDAO.delete(oa);
		
	}


	@Override
	public List<OeuvreAdherent> findResaByIdAdherent(long idAdherent) {
		return oeuvreAdherentDAO.findByAdherent(idAdherent);
	}
}
