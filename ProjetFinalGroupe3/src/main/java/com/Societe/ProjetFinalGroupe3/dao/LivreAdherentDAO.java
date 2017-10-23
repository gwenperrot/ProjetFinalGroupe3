package com.Societe.ProjetFinalGroupe3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Societe.ProjetFinalGroupe3.metier.LivreAdherent;
import com.Societe.ProjetFinalGroupe3.metier.LivreAdherentId;
import com.Societe.ProjetFinalGroupe3.metier.OeuvreAdherent;

public interface LivreAdherentDAO extends JpaRepository<LivreAdherent, LivreAdherentId> {

	@Query("select la from LivreAdherent la where la.idLA.adherent.idUtilisateur= :x")
	List<LivreAdherent> findByAdherent(@Param ("x") Long idAdherent);
}
