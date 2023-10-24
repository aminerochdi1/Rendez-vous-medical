package com.ehei.rendezvous.medical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RendezVousMedicalApplication {

	public static void main(String[] args) {
		//ApplicationContext ctx = (ApplicationContext)

		// IOC CONTAINER TO ACCESS DIFFERENT RESOURCES
		SpringApplication.run(RendezVousMedicalApplication.class, args);

		/*
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof UserDetails) {
				String username = ((UserDetails) principal).getUsername();
				String pwd = ((UserDetails) principal).getPassword();
				// Use the 'username' as needed
				System.out.println("username : " + username);
				System.out.println("password : " + pwd);
			}

		}
		*/


	}
}
