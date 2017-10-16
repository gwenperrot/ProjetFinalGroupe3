package com.Societe.ProjetFinalGroupe3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Societe.ProjetFinalGroupe3.metier.Auteur;
@Repository
public interface AuteurDAO extends JpaRepository<Auteur, Long> {
	 	List<Auteur> findByNom(String nom);
		@Query("select a from Auteur a where a.nom like :y")
		List<Auteur> rechercheParAuteur(@Param("y") String auteur);
}
