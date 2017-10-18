package com.Societe.ProjetFinalGroupe3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Societe.ProjetFinalGroupe3.dao.AdherentDAO;
import com.Societe.ProjetFinalGroupe3.dao.AdministrateurDAO;
import com.Societe.ProjetFinalGroupe3.dao.AuteurDAO;
import com.Societe.ProjetFinalGroupe3.dao.LivreDAO;
import com.Societe.ProjetFinalGroupe3.dao.OeuvreDAO;
import com.Societe.ProjetFinalGroupe3.dao.UtilisateurDAO;
import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Auteur;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.LivreAdherent;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;
import com.Societe.ProjetFinalGroupe3.metier.Utilisateur;

@Service
public class ServiceAdministrateurImpl implements IServiceAdministrateur {
	@Autowired
	AdministrateurDAO administrateurDAO;
	@Autowired
	AdherentDAO adherentDAO;
	@Autowired
	LivreDAO livreDAO;
	@Autowired
	OeuvreDAO oeuvreDAO;
	@Autowired
	AuteurDAO auteurDAO;
	@Autowired
	UtilisateurDAO utilisateurDAO;
	
	
	
	/*CRUD Auteur*/
	
	public UtilisateurDAO getUtilisateurDAO() {
		return utilisateurDAO;
	}

	public void setUtilisateurDAO(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	public AdministrateurDAO getAdministrateurDAO() {
		return administrateurDAO;
	}

	public void setAdministrateurDAO(AdministrateurDAO administrateurDAO) {
		this.administrateurDAO = administrateurDAO;
	}

	public AdherentDAO getAdherentDAO() {
		return adherentDAO;
	}

	public void setAdherentDAO(AdherentDAO adherentDAO) {
		this.adherentDAO = adherentDAO;
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

	public AuteurDAO getAuteurDAO() {
		return auteurDAO;
	}

	public void setAuteurDAO(AuteurDAO auteurDAO) {
		this.auteurDAO = auteurDAO;
	}

	@Override
	public Auteur createAuteur(Auteur a) {
		return auteurDAO.save(a);
	}

	@Override
	public Auteur updateAuteur(Auteur a) {
		return auteurDAO.saveAndFlush(a);
	}
	
	@Override
	public Auteur getAuteur(long idAuteur) {
		return auteurDAO.findById(idAuteur).get();
	}

	@Override
	public List<Auteur> findAllAuteur() {
		return auteurDAO.findAll();
	}

	@Override
	public void deleteAuteur(long idAuteur) {
		auteurDAO.deleteById(idAuteur);
	}
	
	/*CRUD Adherent*/

	@Override
	public Adherent createAdherent(Adherent ad) {
		return adherentDAO.save(ad);
	}

	@Override
	public Adherent updateAdherent(Adherent ad) {
		return adherentDAO.saveAndFlush(ad);
	}
	
	@Override
	public Adherent getAdherent(long idUtilisateur) {
		return 	adherentDAO.findById(idUtilisateur).get();
	}

	@Override
	public List<Adherent> findAllAdherent() {
		return 	adherentDAO.findAll();
	}
	
	@Override
	public void deleteAdherent(long id) {
		adherentDAO.deleteById(id);
	}
	
	/*CRUD Oeuvre*/
	
	@Override
	public Oeuvre createOeuvre(Oeuvre o) {
		
		return oeuvreDAO.save(o);
	}

	@Override
	public Oeuvre updateOeuvre(Oeuvre o) {
		return oeuvreDAO.saveAndFlush(o);
	}
	
	@Override
	public Oeuvre getOeuvre(long idOeuvre) {
		return 	oeuvreDAO.findById(idOeuvre).get();
	}

	@Override
	public List<Oeuvre> findAllOeuvre() {
		return oeuvreDAO.findAll();
	}

	@Override
	public void deleteOeuvre(long idOeuvre) {
		oeuvreDAO.deleteById(idOeuvre);
	}

	/*CRUD Livre*/
	
	@Override
	public Livre createLivre(Livre l) {
		return livreDAO.save(l);
	}

	@Override
	public Livre updateLivre(Livre l) {
		return livreDAO.saveAndFlush(l);
	}
	
	@Override
	public Livre getLivre(long idLivre) {
		return livreDAO.findById(idLivre).get();
	}

	@Override
	public List<Livre> findAllLivre() {
		return livreDAO.findAll();
	}

	@Override
	public void deleteLivre(long idLivre) {
		livreDAO.deleteById(idLivre);
		
	}

	/*Recherche de LIVRE pour l'Administrateur*/
	
	@Override
	public List<Oeuvre> rechercheParOeuvre(String o) {
		return oeuvreDAO.rechercherParOeuvre(o);
	}
	@Override
	public List<Oeuvre> rechercherParMC(String mc) {
		return oeuvreDAO.rechercherParMC(mc+"%");
	}

	@Override
	public List<Auteur> rechercherParAuteur(String auteur) {
		return auteurDAO.rechercheParAuteur(auteur);
	}



	/*Recherche d'ADHERENT pour l'Administrateur*/
	
//	@Override
//	public List<Adherent> rechercherParId(long idUtilisateur) {
//		return administrateurDAO.rechercherParId(idUtilisateur);
//	}
	
	@Override
	public void attribuerOeuvreAuteur(Oeuvre o, Auteur a) {
		
			o.setLauteur(a);
			oeuvreDAO.saveAndFlush(o);
	}

	@Override
	public void attribuerLivreOeuvre(Livre l, Oeuvre o) {
			l.setLoeuvre(o);
			livreDAO.saveAndFlush(l);
	}

	@Override
	public List<Oeuvre> findByTitre(String titre) {
		return oeuvreDAO.findByTitre(titre);
	}
	
	@Override
	public Utilisateur rechercheByLogin (String login) {
		return utilisateurDAO.rechercheByLogin(login);
		
	}
	

	@Override
	public String rechercherType(Utilisateur u) {
		return utilisateurDAO.rechercherType(u);
	}

	
}
