package com.ehei.rendezvousmedical.service;

import com.ehei.rendezvousmedical.model.Utilisateur;
import com.ehei.rendezvousmedical.web.dto.UtilisateurRegistration;

public interface UtilisateurService {
	
	Utilisateur ajouter(UtilisateurRegistration RegistrationDto);
	
	
}
