package com.ehei.rendezvousmedical.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehei.rendezvousmedical.model.Utilisateur;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur,Long>
{	
	
}
