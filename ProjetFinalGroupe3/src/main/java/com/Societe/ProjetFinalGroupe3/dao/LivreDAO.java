package com.Societe.ProjetFinalGroupe3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Societe.ProjetFinalGroupe3.metier.Livre;
@Repository
public interface LivreDAO extends JpaRepository<Livre, Long> {
	
	List<Livre> findByLoeuvre(String loeuvre);
	@Query("select l from Livre l where l.loeuvre like :x")
	List <Livre> rechercherParMC(@Param("x") String mc);
}
