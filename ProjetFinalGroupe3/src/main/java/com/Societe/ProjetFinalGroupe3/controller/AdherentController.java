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
import com.Societe.ProjetFinalGroupe3.service.IServiceAdherent;

@CrossOrigin
@RestController
public class AdherentController {
	@Autowired
	private IServiceAdherent service;

	/*CRUD adherent*/
	

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

	/*Methodes de recherche pour l'Adherent*/
	
	
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
	
	/*Methodes d'emprunt et de reservation pour l'Adherent*/
	
//	@RequestMapping("/emprunterReserver")
//	public void emprunter(Oeuvre o , Adherent ad) {
//		if (Oeuvre.nbLivreLibre != 0 ) {
//			service.emprunter(o, ad);
//		}
//		else  {
//			service.reserver(o, ad);
//		}
//	}
}
