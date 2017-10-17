package com.Societe.ProjetFinalGroupe3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Societe.ProjetFinalGroupe3.metier.Utilisateur;

@CrossOrigin
@RestController
public class ConnexionController {

	Utilisateur u = new Utilisateur();

	public Utilisateur getU() {
		return u;
	}


	public void setU(Utilisateur u) {
		this.u = u;
	}

	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public String checkPassword() {
		if (u.getLogin() != null && u.getMdp() != null && u.isAdmin() == true) {
			return "navigationadmin";
		} else if (u.getLogin() != null && u.getMdp() != null && u.isAdmin() == false) {
			return "navigationadherent";
		} else {
			return "";

		}

	}

}
