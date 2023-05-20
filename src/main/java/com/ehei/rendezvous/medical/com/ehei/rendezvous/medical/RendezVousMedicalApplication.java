package com.ehei.rendezvous.medical.com.ehei.rendezvous.medical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.ehei.rendezvousmedical.model"})
public class RendezVousMedicalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RendezVousMedicalApplication.class, args);
		
	}	

}
