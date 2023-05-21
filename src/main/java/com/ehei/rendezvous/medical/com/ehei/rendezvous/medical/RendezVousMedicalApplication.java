package com.ehei.rendezvous.medical.com.ehei.rendezvous.medical;
import org.springframework.stereotype.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties
@EnableJpaRepositories("om.ehei.rendezvousmedical.repository.UtilisateurRepo")
@ComponentScan({"com.ehei.rendezvousmedical.service.UtilisateurService"})
@ComponentScan({"com.ehei.rendezvousmedical.repository.UtilisateurRepo"})
@EntityScan({"com.ehei.rendezvousmedical.model"})
public class RendezVousMedicalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RendezVousMedicalApplication.class, args);
		
	}	
}
