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
	

	public IServiceAdherent getService() {
		return service;
	}

	public void setService(IServiceAdherent service) {
		this.service = service;
	}

	@RequestMapping(value = "/saveAdherent", method = RequestMethod.POST)
	public void save(@RequestBody Adherent ad) {
		service.createAdherent(ad);
	}

	@RequestMapping(value = "/updateAdherent",method = RequestMethod.POST)
	public void updateAdherent(@RequestBody Adherent ad) {
		service.updateAdherent(ad);
	}

	@RequestMapping(value = "/getAdherent", method = RequestMethod.POST)
	public Adherent getAdherent(@RequestBody long idUtilisateur) {
		return service.getAdherent(idUtilisateur);
	}

	@RequestMapping(value = "/allAdherent", method = RequestMethod.GET)
	public List<Adherent> allAdherent() {
		return service.findAllAdherent();
	}
	
	@RequestMapping(value = "/deleteAdherent", method = RequestMethod.POST)
	public void deleteAdherent(long idUtilisateur) {
		service.deleteAdherent(idUtilisateur);
	}

	/*Methodes de recherche pour l'Adherent*/
	
	
	@RequestMapping(value = "/livreParMC", method = RequestMethod.POST)
	public List<Livre> rechercherParMC(String mc) {
		return service.rechercherParMC(mc);
	}
	
	@RequestMapping(value = "/livreParAuteur",method = RequestMethod.POST)
	public List<Oeuvre> rechercherParAuteur(Oeuvre o) {
		return service.rechercherParAuteur(o);
	}
	
	@RequestMapping(value = "/parOeuvre",  method = RequestMethod.POST)
	public List<Oeuvre> rechercherParOeuvre(Oeuvre o ) {
		return service.rechercheParOeuvre(o);
	}
	
	
	/*Methodes d'emprunt et de reservation pour l'Adherent*/
	
	@RequestMapping(value = "/emprunterReserver", method = RequestMethod.POST)
	public void emprunter(Livre l  , Adherent ad) {
		if (l.isDispo() == true) {
			service.emprunter(l, ad)
			;
			
		}
		else  {
			Oeuvre o = new Oeuvre();
			service.reserver(o, ad);
		}
	}
	
	@RequestMapping(value = "/retour", method = RequestMethod.POST) 
	public void retour(Livre l , Adherent ad) {
		service.retour(l, ad);
	}
}
