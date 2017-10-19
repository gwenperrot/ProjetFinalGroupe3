package com.Societe.ProjetFinalGroupe3.Tests;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.Societe.ProjetFinalGroupe3.dao.AdherentDAO;
import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;
import com.Societe.ProjetFinalGroupe3.service.IServiceAdministrateur;
import com.Societe.ProjetFinalGroupe3.service.ServiceAdministrateurImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"webapp/WEB-INF/web.xml"})
public class TestAdmin {
	@Autowired
	AdherentDAO adherentDAO;

	IServiceAdministrateur admin = new ServiceAdministrateurImpl();
	
	Oeuvre oeuvre = new Oeuvre();
	
	Livre livre = new Livre();
	
	
	@Ignore
	@Test
	public void testCreateAdherent() {
		fail("Not yet implemented");
		
		Adherent a = new Adherent();
		a.setNom("Elipse");
		a.setPrenom("Java");
		a.setLogin("Spring");
		a.setMdp("merde!");
		a.setVille("Paris");
		a.setDateIns(new Date (2015-05-11));
		a.setCodePostal(75000);
		a.setNumTel("0239856412");
		a.setTYPE_Utilisateur("adherent");
		admin.createAdherent(a);
	}
	
	
	@Ignore
	@Test
	public void testRechercheParOeuvre() {
		fail("Not yet implemented");
		admin.rechercheParOeuvre("JAVA");
		
	}
	@Ignore
	@Test
	public void testAttribuerLivreOeuvre() {
		fail("Not yet implemented");
		
		oeuvre = admin.getOeuvre(7);
		livre = admin.getLivre(22);
		admin.attribuerLivreOeuvre(livre, oeuvre);	
	}

}
