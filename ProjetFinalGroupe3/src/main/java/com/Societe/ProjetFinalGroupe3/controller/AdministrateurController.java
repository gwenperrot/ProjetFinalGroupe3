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

	@RequestMapping(value = "/saveAuteur", method = RequestMethod.POST)
	public void save(@RequestBody Auteur a) {
		service.createAuteur(a);
	}

	@RequestMapping("/updateAuteur")
	public void updateAuteur(Auteur a) {
		service.updateAuteur(a);
	}
	
	@RequestMapping("/getAuteur")
	public Auteur getAuteur(long idAuteur) {
		return service.getAuteur(idAuteur);
	}

	@RequestMapping("/allAuteur")
	public List<Auteur> allAuteur() {
		return service.findAllAuteur();
	}
	
	@RequestMapping("/deleteAuteur")
	public void deleteAuteur(long idAuteur) {
		service.deleteAuteur(idAuteur);
	}
	
	/*CRUD Adherent*/
	

	@RequestMapping(value = "/saveAdherent", method = RequestMethod.POST)
	public void save(@RequestBody Adherent ad) {
		service.createAdherent(ad);
	}

	@RequestMapping("/updateAdherent")
	public void updateAdherent(Adherent ad) {
		service.updateAdherent(ad);
	}

	@RequestMapping("/getAdherent")
	public Adherent getAdherent(long idAdherent) {
		return service.getAdherent(idAdherent);
	}

	@RequestMapping("/allAdherent")
	public List<Adherent> allAdherent() {
		return service.findAllAdherent();
	}
	
	@RequestMapping("/deleteAdherent")
	public void deleteAdherent(long idAdherent) {
		service.deleteAdherent(idAdherent);
	}

	
	/*CRUD Oeuvre*/
	
	@Autowired
	@RequestMapping(value = "/saveOeuvre", method = RequestMethod.POST)
	public void save(@RequestBody Oeuvre o) {
		service.createOeuvre(o);
	}

	@RequestMapping("/updateOeuvre")
	public void updateOeuvre(Oeuvre o) {
		service.updateOeuvre(o);
	}

	@RequestMapping("/getOeuvre")
	public Oeuvre getOeuvre(long idOeuvre) {
		return service.getOeuvre(idOeuvre);
	}

	@RequestMapping("/allOeuvre")
	public List<Oeuvre> allOeuvre() {
		return service.findAllOeuvre();
	}
	
	@RequestMapping("/deleteOeuvre")
	public void deleteOeuvre(long idOeuvre) {
		service.deleteOeuvre(idOeuvre);
	}
	
	/*CRUD Livre*/
	
	@RequestMapping(value = "/saveLivre", method = RequestMethod.POST)
	public void save(@RequestBody Livre l) {
		service.createLivre(l);
	}

	@RequestMapping("/updateLivre l")
	public void updateLivre(Livre l) {
		service.updateLivre(l);
	}

	@RequestMapping("/getLivre")
	public Livre getLivre(long idLivre) {
		return service.getLivre(idLivre);
	}

	@RequestMapping("/allLivre")
	public List<Livre> allLivre() {
		return service.findAllLivre();
	}
	
	@RequestMapping("/deleteLivre")
	public void deleteLivre (long idLivre) {
		service.deleteLivre(idLivre);
	}
	
	/*Methodes de recherche pour l'administrateur*/
	@RequestMapping("/livreParMC")
	public List<Livre> rechercherParMC(String mc) {
		return service.rechercherParMC(mc);
	}
	
	@RequestMapping("/livreParAuteur")
	public List<Oeuvre> rechercherParAuteur(Oeuvre o) {
		return service.rechercherParAuteur(o);
	}
	
	@RequestMapping("/parOeuvre")
	public List<Oeuvre> rechercherParOeuvre(Oeuvre o ) {
		return service.rechercheParOeuvre(o);
	}
	
	@RequestMapping("/adherentParId")
	public List<Adherent> rechercherParId(long idAdherent ) {
		return service.rechercherParId(idAdherent);
	}
}
