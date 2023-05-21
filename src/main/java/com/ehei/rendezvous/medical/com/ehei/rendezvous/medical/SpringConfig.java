package com.ehei.rendezvous.medical.com.ehei.rendezvous.medical;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ehei.rendezvousmedical.service.UtilisateurService;
import com.ehei.rendezvousmedical.service.UtilisateurServiceImp;

@Configuration 
@EnableJpaRepositories(basePackages = "com.ehei.rendezvousmedical.repository.UtilisateurRepo")

public class SpringConfig implements WebMvcConfigurer { 

	public void addViewControllers(ViewControllerRegistry registry)
	   {
	      registry.addViewController("/").setViewName("registration");
	      registry.addViewController("/registration").setViewName("registration");
	   }
    
}