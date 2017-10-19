package com.Societe.ProjetFinalGroupe3.Tests;

import org.junit.Ignore;

import org.junit.Test;

import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.LivreAdherent;
import com.Societe.ProjetFinalGroupe3.service.IServiceAdherent;
import com.Societe.ProjetFinalGroupe3.service.ServiceAdherentImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"webapp/WEB-INF/web.xml"})
public class TestAdherent {
	Adherent adherent = new Adherent ();
	IServiceAdherent serviceAdherent = new ServiceAdherentImpl();
	LivreAdherent emprunt = new LivreAdherent();
	Livre livre;
	
	@Ignore
	@Test
	public void testUpdateAdherent() {
		//fail("Not yet implemented");
		adherent = serviceAdherent.getAdherent(2);
		adherent.setNom("Bouh");
		serviceAdherent.updateAdherent(adherent);
		
	}
	
	//@Ignore
	@Test
	public void testDeleteAdherent() {
		//fail("Not yet implemented");
		serviceAdherent.deleteAdherent(8);
	}


}
