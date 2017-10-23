package com.Societe.ProjetFinalGroupe3.metier;



import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


/*
 * Classe repr�sentant la table de jointure entre Oeuvre et Adherent
 */

@Entity
public class LivreAdherent{
	/*
	 * D�claration de la clef compos�e
	 *
	 */
	//@JsonIgnore
	@EmbeddedId
	private LivreAdherentId idLA;
	
	/*
	 * d�claration des attributs qui feront partie 
	 * de la table de jointure
	 */
	private int numeroEmprunt;
	
	
	public LivreAdherent(Livre livre, Adherent adherent) {
		this.idLA = new LivreAdherentId(livre,adherent);
	}
/*
 * d�claration de la cl� composite
 */

	public LivreAdherent() {
		super();
	}
	


	public LivreAdherentId getIdLA() {
		return idLA;
	}

	public void setIdLA(LivreAdherentId idLA) {
		this.idLA = idLA;
	}



	
	public int getNumeroEmprunt() {
		return numeroEmprunt;
	}
	public void setNumeroEmprunt(int numeroEmprunt) {
		this.numeroEmprunt = numeroEmprunt;
	}

	

}
