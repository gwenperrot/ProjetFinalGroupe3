package com.Societe.ProjetFinalGroupe3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Societe.ProjetFinalGroupe3.metier.Adherent;
import com.Societe.ProjetFinalGroupe3.metier.Livre;
import com.Societe.ProjetFinalGroupe3.metier.Oeuvre;



@Repository
public interface AdherentDAO extends JpaRepository<Adherent, Long> {


 
	@Query("select l from Livre l left join fetch l.adherent  where l.adherent.idUtilisateur=?")
	void emprunter (Livre l, Adherent ad);

	@Query("select o from Oeuvre o left join fetch o.adherent  where o.adherent.idUtilisateur=?")
	void reserver(Oeuvre o, Adherent ad);

}


