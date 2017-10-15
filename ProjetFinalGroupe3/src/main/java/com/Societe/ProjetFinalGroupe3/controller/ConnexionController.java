package com.Societe.ProjetFinalGroupe3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.Societe.ProjetFinalGroupe3.metier.Utilisateur;

@CrossOrigin
@RestController
public class ConnexionController {
	Utilisateur u = new Utilisateur();

	@Autowired
	public String checkPassword() {
		if (u.getLogin() != null && u.getMdp() != null && u.getAdministrateur() == true) {
			return "navigationadmin";
		} else if (u.getLogin() != null && u.getMdp() != null && u.getAdministrateur() == false) {
			return "navigationadherent";
		} else {
			return "";

		}

	}

}
