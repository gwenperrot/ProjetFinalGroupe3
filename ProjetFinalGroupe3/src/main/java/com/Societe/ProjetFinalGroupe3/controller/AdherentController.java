package com.Societe.ProjetFinalGroupe3.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

	/* CRUD adherent */

	public IServiceAdherent getService() {
		return service;
	}

	public void setService(IServiceAdherent service) {
		this.service = service;
	}

	@RequestMapping(value = "/saveAdherent", method = RequestMethod.GET)
	public void save(Adherent ad) {
		String login = ad.getLogin();

		if (service.rechercheByLogin(login) == null) {
			service.createAdherent(ad);
		}

	}

	@RequestMapping(value = "/updateAdherent", method = RequestMethod.POST)
	public void updateAdherent(@RequestBody Adherent ad) {
		String login = ad.getLogin();
		if (service.rechercheByLogin(login) == null)
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
	public void deleteAdherent(@RequestBody long idUtilisateur) {
		service.deleteAdherent(idUtilisateur);
	}

	/* Methodes de recherche pour l'Adherent */

	@RequestMapping(value = "/livreParMC", method = RequestMethod.POST)
	public List<Oeuvre> rechercherParMC(@RequestBody String mc) {
		return service.rechercherParMC(mc);
	}

	@RequestMapping(value = "/livreParAuteur", method = RequestMethod.POST)
	public List<Auteur> rechercherParAuteur(@RequestBody String a) {
		return service.rechercherParAuteur(a);
	}

	@RequestMapping(value = "/parOeuvre", method = RequestMethod.POST)
	public List<Oeuvre> rechercherParOeuvre(@RequestBody String o) {
		return service.rechercheParOeuvre(o);
	}

	/* Methodes d'emprunt et de reservation pour l'Adherent */

	@RequestMapping(value = "/emprunterReserver", method = RequestMethod.GET)
	public void emprunter(long idOeuvre, long idAdherent) {

		Adherent ad;
		Oeuvre o;
		ad = service.getAdherent(idAdherent);
		o = service.getOeuvre(idOeuvre);
		int nbl = o.getNbLivreLibre();

		if (nbl > 0) {
			Set<Livre> livres = o.getLivres();
			Livre l = new Livre();

			Object[] ls = livres.toArray();
			int t = 0;

			while (!((Livre) ls[t]).isDispo()) {
				t++;
			}
			l = (Livre) ls[t];
			l.setDispo(false);
			nbl--;
			o.setNbLivreLibre(nbl);
			service.emprunter(o, l, ad);
		}else {

		service.reserver(o, ad);}
	}

	@RequestMapping(value = "/retour", method = RequestMethod.POST)
	public void retour(Livre l, Adherent ad) {
		Oeuvre o = l.getLoeuvre();
		int nbl = o.getNbLivreLibre();
		service.retour(l, ad);
		nbl++;

	}
}
