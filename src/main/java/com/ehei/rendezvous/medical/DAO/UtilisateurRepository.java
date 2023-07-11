package com.ehei.rendezvous.medical.DAO;

import com.ehei.rendezvous.medical.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>
{

}
