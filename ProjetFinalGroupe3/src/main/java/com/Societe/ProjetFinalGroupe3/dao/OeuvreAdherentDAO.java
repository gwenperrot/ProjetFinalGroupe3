package com.Societe.ProjetFinalGroupe3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Societe.ProjetFinalGroupe3.metier.OeuvreAdherent;
import com.Societe.ProjetFinalGroupe3.metier.OeuvreAdherentId;

public interface OeuvreAdherentDAO extends JpaRepository<OeuvreAdherent, OeuvreAdherentId> {

}
