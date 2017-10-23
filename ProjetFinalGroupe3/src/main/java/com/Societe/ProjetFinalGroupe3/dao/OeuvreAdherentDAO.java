package com.Societe.ProjetFinalGroupe3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Societe.ProjetFinalGroupe3.metier.OeuvreAdherent;
import com.Societe.ProjetFinalGroupe3.metier.OeuvreAdherentId;

public interface OeuvreAdherentDAO extends JpaRepository<OeuvreAdherent, OeuvreAdherentId> {
	
	@Query("select oa from OeuvreAdherent oa where oa.idOA.adherent.idUtilisateur= :x")
	List<OeuvreAdherent> findByAdherent(@Param ("x") Long idAdherent);
}
