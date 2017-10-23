package com.Societe.ProjetFinalGroupe3.metier;
/*
 * Classe embarqu�e entre les classes Oeuvre et Adherent
 */
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class OeuvreAdherentId implements Serializable{
/*
 * Clef compos�e d'une oeuvre et d'un adherent
 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Oeuvre_Id")
	private Oeuvre oeuvre;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Adherent_Id")
	private Adherent adherent;
	
	
	public OeuvreAdherentId() {
		super();
	}


	public OeuvreAdherentId(Oeuvre oeuvre, Adherent adherent) {
		super();
		this.oeuvre = oeuvre;
		this.adherent = adherent;
	}
	
	/*
	 * => 1 Id Compose(vol+CompagnieAerienne) 
	 * peut contenir plusieurs Id vol
	 */
	
	

		public Oeuvre getOeuvre() {
			return oeuvre;
		}


		public void setOeuvre(Oeuvre oeuvre) {
			this.oeuvre = oeuvre;
		}

		public Adherent getAdherent() {
			return adherent;
		}


		public void setAdherent(Adherent adherent) {
			this.adherent = adherent;
		}


		

//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime
//					* result
//					+ ((oeuvre == null) ? 0 : oeuvre
//							.hashCode());
//			result = prime * result + ((adherent == null) ? 0 : adherent.hashCode());
//			return result;
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			OeuvreAdherentId other = (OeuvreAdherentId) obj;
//			if (oeuvre == null) {
//				if (other.oeuvre != null)
//					return false;
//			} else if (!oeuvre.equals(other.oeuvre))
//				return false;
//			if (adherent == null) {
//				if (other.adherent != null)
//					return false;
//			} else if (!adherent.equals(other.adherent))
//				return false;
//			return true;
//		}
}
