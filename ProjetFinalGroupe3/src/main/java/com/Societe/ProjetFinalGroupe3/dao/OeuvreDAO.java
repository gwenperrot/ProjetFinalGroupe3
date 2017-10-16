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
	
	
	List<Oeuvre> findByTitre(String titre);
	@Query("select o from Oeuvre o where o.titre like :z")
	List<Oeuvre> rechercherParOeuvre (@Param ("z") String oeuvre);
	
	@Query("select o from Oeuvre o where o.titre like :x")
	List <Oeuvre> rechercherParMC(@Param("x") String mc);
}
