package com.Societe.ProjetFinalGroupe3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Societe.ProjetFinalGroupe3.metier.Utilisateur;

@Repository
public interface UtilisateurDAO extends JpaRepository<Utilisateur, Long> {

	List<Utilisateur>findByLogin(String Login);
	@Query("select u from Utilisateur u where u.login like :l")
	Utilisateur rechercheByLogin (@Param ("l") String login );
	
//	@Query("select TYPE_Utilisateur from Utilisateur u like :p ")
//	String rechercherType(@Param ("p") Utilisateur  p);
//	
	
}
