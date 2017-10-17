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
	public void updateAuteur(@RequestBody Auteur a) {
		service.updateAuteur(a);
	}
	
	@RequestMapping(value = "/getAuteur", method = RequestMethod.POST)
	public Auteur getAuteur(@RequestBody long idAuteur) {
		return service.getAuteur(idAuteur);
	}

	@RequestMapping(value = "/allAuteur", method = RequestMethod.GET)
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
	public void updateAdherent(@RequestBody Adherent ad) {
		service.updateAdherent(ad);
	}

	@RequestMapping(value =  "/getAdherentAdmin", method = RequestMethod.POST)
	public Adherent getAdherent(@RequestBody long idUtilisateur) {
		return service.getAdherent(idUtilisateur);
	}

	@RequestMapping(value = "/allAdherentAdmin", method = RequestMethod.GET)
	public List<Adherent> allAdherent() {
		return service.findAllAdherent();
	}
	
	@RequestMapping(value = "/deleteAdherentAdmin" , method = RequestMethod.POST)
	public void deleteAdherent(@RequestBody long idUtilisateur) {
		service.deleteAdherent(idUtilisateur);
	}

	
	/*CRUD Oeuvre*/
	
	@RequestMapping(value = "/saveOeuvre", method = RequestMethod.POST)
	public void save(@RequestBody Oeuvre o) {
		service.createOeuvre(o);
	}

	@RequestMapping(value = "/updateOeuvre", method = RequestMethod.POST)
	public void updateOeuvre(@RequestBody Oeuvre o) {
		service.updateOeuvre(o);
	}

	@RequestMapping(value = "/getOeuvre", method = RequestMethod.POST)
	public Oeuvre getOeuvre(@RequestBody long idOeuvre) {
		return service.getOeuvre(idOeuvre);
	}

	@RequestMapping(value = "/allOeuvre", method = RequestMethod.GET)
	public List<Oeuvre> allOeuvre() {
		return service.findAllOeuvre();
	}
	
	@RequestMapping(value = "/deleteOeuvre", method = RequestMethod.POST)
	public void deleteOeuvre(@RequestBody long idOeuvre) {
		service.deleteOeuvre(idOeuvre);
	}
	
	/*CRUD Livre*/
	
	@RequestMapping(value = "/saveLivre", method = RequestMethod.POST)
	public void save(@RequestBody Livre l) {
		service.createLivre(l);
	}

	@RequestMapping(value = "/updateLivre l", method = RequestMethod.POST)
	public void updateLivre(@RequestBody Livre l) {
		service.updateLivre(l);
	}

	@RequestMapping(value = "/getLivre", method = RequestMethod.POST)
	public Livre getLivre(@RequestBody long idLivre) {
		return service.getLivre(idLivre);
	}

	@RequestMapping(value = "/allLivre", method = RequestMethod.GET)
	public List<Livre> allLivre() {
		return service.findAllLivre();
	}
	
	@RequestMapping(value = "/deleteLivre", method = RequestMethod.POST)
	public void deleteLivre (@RequestBody long idLivre) {
		service.deleteLivre(idLivre);
	}
	
	/*Methodes de recherche pour l'administrateur*/
	@RequestMapping(value = "/livreParMCAdmin", method = RequestMethod.POST)
	public List<Oeuvre> rechercherParMC(@RequestBody String mc) {
		return service.rechercherParMC(mc);
	}
	
	@RequestMapping(value = "/livreParAuteurAdmin", method = RequestMethod.POST)
	public List<Auteur> rechercherParAuteur(@RequestBody String a) {
		return service.rechercherParAuteur(a);
	}
	
	@RequestMapping(value = "/parOeuvreAdmin", method = RequestMethod.POST)
	public List<Oeuvre> rechercherParOeuvre(@RequestBody String o ) {
		return service.rechercheParOeuvre(o);
	}
	
//	@RequestMapping(value = "/adherentParId" , method = RequestMethod.POST)
//	public List<Adherent> rechercherParId(@RequestBody long idUtilisateur ) {
//		return service.rechercherParId(idUtilisateur);
//	}
	@RequestMapping(value = "/attibuerOeuvreAuteur " ,  method = RequestMethod.POST)
	public void attribuerOeuvreAuteur(@RequestBody long idOeuvre, long idAuteur) {
		
		Auteur a = service.getAuteur(idAuteur);
		Oeuvre o = service.getOeuvre(idOeuvre);
		
		service.attribuerOeuvreAuteur(o, a);
	}
		
	@RequestMapping(value = "/attibuerLivreOeuvre " ,  method = RequestMethod.POST)
	public void attribuerLivreOeuvre(@RequestBody long idLivre, long idOeuvre) {
		
		Livre l = service.getLivre(idLivre);
		Oeuvre o = service.getOeuvre(idOeuvre);
		
		service.attribuerLivreOeuvre(l, o);
	}
	
}
