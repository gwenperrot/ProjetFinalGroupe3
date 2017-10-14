package com.Societe.ProjetFinalGroupe3.metier;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * Classe repr�sentant la table de jointure entre Oeuvre et Adherent
 */

@Entity
@Table(name="OeuvreAdherent")
public class OeuvreAdherent{
	/*
	 * D�claration de la clef compos�e
	 *
	 */
	@EmbeddedId
	private OeuvreAdherentId idOA;
	
	/*
	 * d�claration des attributs qui feront partie 
	 * de la table de jointure
	 */
	private int numeroReservation;
	
	
	public OeuvreAdherent(Oeuvre oeuvre, Adherent adherent) {
		this.idOA = new OeuvreAdherentId(oeuvre,adherent);
	}




/*
 * d�claration de la cl� composite
 */

	public OeuvreAdherent() {
		super();
	}

	


	public OeuvreAdherentId getIdOA() {
		return idOA;
	}

	public void setIdOA(OeuvreAdherentId idOA) {
		this.idOA = idOA;
	}

	public int getNumeroReservation() {
		return numeroReservation;
	}

	public void setNumeroReservation(int numeroReservation) {
		this.numeroReservation = numeroReservation;
	}




	
	

}
