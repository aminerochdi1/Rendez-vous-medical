package com.ehei.rendezvousmedical.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ehei.rendezvousmedical.service.UtilisateurService;
import com.ehei.rendezvousmedical.web.dto.UtilisateurRegistration;

@RestController
@RequestMapping("/registration")
//@RequestMapping(value = { "/display-form", "/registration.html" }, method = RequestMethod.GET)
public class UtilisateurRegistrationController {

	@Autowired
	private UtilisateurService utilisateurService;

	public UtilisateurRegistrationController(UtilisateurService utilisateurService) {
		super();
		this.utilisateurService = utilisateurService;
	}
	

	// Method pour retourner les details d'un utilisateur
	
	@ModelAttribute("utilisateur")
		public UtilisateurRegistration userRegistrationDto()
		{
		
		return new UtilisateurRegistration();
		  
		}
		
	
	@GetMapping
	public String showRegistrationForm()// Model model as a parameter
	{
		//model.addAttribute("utilisateur",new UtilisateurRegistration());
		return "registration";  
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("utilisateur") UtilisateurRegistration registrationDto )
	{
		utilisateurService.ajouter(registrationDto); 
		return "redirect:/registration?success";
	}	
	
}

