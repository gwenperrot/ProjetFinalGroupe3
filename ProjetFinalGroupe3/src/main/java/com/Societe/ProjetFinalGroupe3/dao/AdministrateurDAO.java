package com.Societe.ProjetFinalGroupe3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Administrateur;



@Repository
public interface AdministrateurDAO extends JpaRepository<Administrateur, Long> {

//	@Query("select ad from Adherent ad where ad.idUtilisateur =?")
//	List<Adherent> rechercherParId(long idAdherent);
	

}
