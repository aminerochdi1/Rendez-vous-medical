package com.ehei.rendezvousmedical.service;

import java.beans.JavaBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ehei.rendezvousmedical.model.Utilisateur;
import com.ehei.rendezvousmedical.repository.UtilisateurRepo;
import com.ehei.rendezvousmedical.web.dto.UtilisateurRegistration;

@Service
@Component
public interface UtilisateurService {
	@Autowired
	Utilisateur ajouter(UtilisateurRegistration RegistrationDto);
	
	
}
