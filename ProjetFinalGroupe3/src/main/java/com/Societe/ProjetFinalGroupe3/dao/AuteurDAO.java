package com.Societe.ProjetFinalGroupe3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Societe.ProjetFinalGroupe3.metier.Auteur;
@Repository
public interface AuteurDAO extends JpaRepository<Auteur, Long> {

}
