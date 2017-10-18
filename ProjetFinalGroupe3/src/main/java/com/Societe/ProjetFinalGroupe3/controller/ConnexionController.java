package com.Societe.ProjetFinalGroupe3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Societe.ProjetFinalGroupe3.metier.Utilisateur;
import com.Societe.ProjetFinalGroupe3.service.IServiceAdministrateur;
import com.Societe.ProjetFinalGroupe3.service.ServiceAdministrateurImpl;

@CrossOrigin
@RestController
public class ConnexionController {
	@Autowired
	IServiceAdministrateur service;
	
	Utilisateur u = new Utilisateur();


	

	public IServiceAdministrateur getService() {
		return service;
	}

	public void setService(IServiceAdministrateur service) {
		this.service = service;
	}

	public Utilisateur getU() {
		return u;
	}

	public void setU(Utilisateur u) {
		this.u = u;
	}

	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public Utilisateur connexion(@RequestParam String login,@RequestParam String mdp) {
		u = service.rechercheByLogin(login);
		
		if (u != null && u.getMdp().equals(mdp)) {		
				return u;
		} else {			
			return null;
		}
		

	}

}
