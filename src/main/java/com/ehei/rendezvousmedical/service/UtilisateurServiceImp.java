package com.ehei.rendezvousmedical.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehei.rendezvousmedical.model.Role;
import com.ehei.rendezvousmedical.model.Utilisateur;
import com.ehei.rendezvousmedical.repository.UtilisateurRepo;
import com.ehei.rendezvousmedical.web.dto.UtilisateurRegistration;


@Service
public class UtilisateurServiceImp implements UtilisateurService {

	// INJECTER UTILISATEUR REPOSITORY
		@Autowired
	private UtilisateurRepo utilisateurRepo;
	
	
	public UtilisateurServiceImp(UtilisateurRepo utilisateurRepo) {
		super();
		this.utilisateurRepo = utilisateurRepo;
	}


   // METHOD D'AJOUT UN UTILISATEUR A LA BD
	
	@Override
	public Utilisateur ajouter(UtilisateurRegistration RegistrationDto) {
		
			Utilisateur utilisateur=new Utilisateur(RegistrationDto.getNom(), 
					RegistrationDto.getPrenom(), RegistrationDto.getDateN(), 
					RegistrationDto.getUserAdresse(), RegistrationDto.getEmail(),
					RegistrationDto.getMDP(),
					Arrays.asList(new Role("ROLE_USER")));
		
		return utilisateurRepo.save(utilisateur);
	}

	
	
}
