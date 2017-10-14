package com.Societe.ProjetFinalGroupe3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Societe.ProjetFinalGroupe3.metier.Auteur;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;
@Repository
public interface OeuvreDAO extends JpaRepository<Oeuvre, Long> {
	
	List<Oeuvre> findByLauteur(String lauteur);
	@Query("select o from Oeuvre o where o.lauteur like :y")
	List<Oeuvre> rechercheParAuteur(@Param("y") Oeuvre o);
	
	List<Oeuvre> findByTitre(String titre);
	@Query("select o from Oeuvre o where o.titre like :z")
	List<Oeuvre> rechercherParOeuvre (@Param ("z") Oeuvre o);
}
