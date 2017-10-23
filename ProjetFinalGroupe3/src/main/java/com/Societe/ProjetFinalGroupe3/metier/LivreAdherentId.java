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
public class LivreAdherentId implements Serializable{
/*
 * Clef compos�e d'une oeuvre et d'un adherent
 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Livre_Id")
	private Livre livre;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ADHERENT_ID")
	private Adherent adherent;
	
	
	public LivreAdherentId() {
	
	}


	public LivreAdherentId(Livre livre, Adherent adherent) {
		super();
		this.livre = livre;
		this.adherent = adherent;
	}
	


		public Adherent getAdherent() {
			return adherent;
		}

		public void setAdherent(Adherent adherent) {
			this.adherent = adherent;
		}

		public Livre getLivre() {
			return livre;
		}


		public void setLivre(Livre livre) {
			this.livre = livre;
		}





		

//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime
//					* result
//					+ ((livre == null) ? 0 : livre
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
//			LivreAdherentId other = (LivreAdherentId) obj;
//			if (livre == null) {
//				if (other.livre!= null)
//					return false;
//			} else if (!livre.equals(other.livre))
//				return false;
//			if (adherent == null) {
//				if (other.adherent != null)
//					return false;
//			} else if (!adherent.equals(other.adherent))
//				return false;
//			return true;
//		}
}
