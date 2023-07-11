package com.ehei.rendezvous.medical;

import com.ehei.rendezvous.medical.DAO.UtilisateurRepository;
import com.ehei.rendezvous.medical.entities.Utilisateur;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
public class RendezVousMedicalApplication {

	public static void main(String[] args) {
		//ApplicationContext ctx = (ApplicationContext)

		// IOC CONTAINER TO ACCESS DIFFERENT RESOURCES
		SpringApplication.run(RendezVousMedicalApplication.class, args);


	}	
}
