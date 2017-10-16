package com.Societe.ProjetFinalGroupe3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Societe.ProjetFinalGroupe3.metier.LivreAdherent;
import com.Societe.ProjetFinalGroupe3.metier.LivreAdherentId;

public interface LivreAdherentDAO extends JpaRepository<LivreAdherent, LivreAdherentId> {

}
