package com.Societe.ProjetFinalGroupe3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Auteur;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;
import com.Societe.ProjetFinalGroupe3.service.IServiceAdministrateur;

@CrossOrigin
@RestController
public class AdministrateurController {
	@Autowired
	private IServiceAdministrateur service;
	
	
	/*CRUD Auteur*/

	public IServiceAdministrateur getService() {
		return service;
	}

	public void setService(IServiceAdministrateur service) {
		this.service = service;
	}

	@RequestMapping(value = "/saveAuteur", method = RequestMethod.POST)
	public void save(@RequestBody Auteur a) {
		service.createAuteur(a);
	}

	@RequestMapping(value = "/updateAuteur", method = RequestMethod.POST)
	public void updateAuteur(Auteur a) {
		service.updateAuteur(a);
	}
	
	@RequestMapping(value = "/getAuteur", method = RequestMethod.POST)
	public Auteur getAuteur(long idAuteur) {
		return service.getAuteur(idAuteur);
	}

	@RequestMapping(value = "/allAuteur", method = RequestMethod.POST)
	public List<Auteur> allAuteur() {
		return service.findAllAuteur();
	}
	
	@RequestMapping(value = "/deleteAuteur", method = RequestMethod.POST)
	public void deleteAuteur(long idAuteur) {
		service.deleteAuteur(idAuteur);
	}
	
	/*CRUD Adherent*/
	

	@RequestMapping(value = "/saveAdherentAdmin", method = RequestMethod.POST)
	public void save(@RequestBody Adherent ad) {
		service.createAdherent(ad);
	}

	@RequestMapping(value = "/updateAdherentAdmin", method = RequestMethod.POST)
	public void updateAdherent(Adherent ad) {
		service.updateAdherent(ad);
	}

	@RequestMapping(value =  "/getAdherentAdmin", method = RequestMethod.POST)
	public Adherent getAdherent(long idAdherent) {
		return service.getAdherent(idAdherent);
	}

	@RequestMapping(value = "/allAdherentAdmin", method = RequestMethod.POST)
	public List<Adherent> allAdherent() {
		return service.findAllAdherent();
	}
	
	@RequestMapping(value = "/deleteAdherentAdmin" , method = RequestMethod.POST)
	public void deleteAdherent(long idAdherent) {
		service.deleteAdherent(idAdherent);
	}

	
	/*CRUD Oeuvre*/
	
	@Autowired
	@RequestMapping(value = "/saveOeuvre", method = RequestMethod.POST)
	public void save(@RequestBody Oeuvre o) {
		service.createOeuvre(o);
	}

	@RequestMapping(value = "/updateOeuvre", method = RequestMethod.POST)
	public void updateOeuvre(Oeuvre o) {
		service.updateOeuvre(o);
	}

	@RequestMapping(value = "/getOeuvre", method = RequestMethod.POST)
	public Oeuvre getOeuvre(long idOeuvre) {
		return service.getOeuvre(idOeuvre);
	}

	@RequestMapping(value = "/allOeuvre", method = RequestMethod.POST)
	public List<Oeuvre> allOeuvre() {
		return service.findAllOeuvre();
	}
	
	@RequestMapping(value = "/deleteOeuvre", method = RequestMethod.POST)
	public void deleteOeuvre(long idOeuvre) {
		service.deleteOeuvre(idOeuvre);
	}
	
	/*CRUD Livre*/
	
	@RequestMapping(value = "/saveLivre", method = RequestMethod.POST)
	public void save(@RequestBody Livre l) {
		service.createLivre(l);
	}

	@RequestMapping(value = "/updateLivre l", method = RequestMethod.POST)
	public void updateLivre(Livre l) {
		service.updateLivre(l);
	}

	@RequestMapping(value = "/getLivre", method = RequestMethod.POST)
	public Livre getLivre(long idLivre) {
		return service.getLivre(idLivre);
	}

	@RequestMapping(value = "/allLivre", method = RequestMethod.POST)
	public List<Livre> allLivre() {
		return service.findAllLivre();
	}
	
	@RequestMapping(value = "/deleteLivre", method = RequestMethod.POST)
	public void deleteLivre (long idLivre) {
		service.deleteLivre(idLivre);
	}
	
	/*Methodes de recherche pour l'administrateur*/
	@RequestMapping(value = "/livreParMC", method = RequestMethod.POST)
	public List<Livre> rechercherParMC(String mc) {
		return service.rechercherParMC(mc);
	}
	
	@RequestMapping(value = "/livreParAuteur", method = RequestMethod.POST)
	public List<Oeuvre> rechercherParAuteur(Oeuvre o) {
		return service.rechercherParAuteur(o);
	}
	
	@RequestMapping(value = "/parOeuvre", method = RequestMethod.POST)
	public List<Oeuvre> rechercherParOeuvre(Oeuvre o ) {
		return service.rechercheParOeuvre(o);
	}
	
	@RequestMapping(value = "/adherentParId" , method = RequestMethod.POST)
	public List<Adherent> rechercherParId(long idAdherent ) {
		return service.rechercherParId(idAdherent);
	}
}
