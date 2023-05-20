package com.ehei.rendezvousmedical.web.dto;

import java.sql.Date;

import jakarta.persistence.Column;

public class UtilisateurRegistration {


	
	
	public UtilisateurRegistration(String nom, String prenom, Date dateN, String userAdresse, String email,
			String mDP) {
		super();
		Nom = nom;
		Prenom = prenom;
		this.dateN = dateN;
		UserAdresse = userAdresse;
		this.email = email;
		MDP = mDP;
	}
	
	public UtilisateurRegistration()
	{
		
	}
	
	
	@Column(name="nom")
	private String Nom;
	@Column(name="prenom")
	private String Prenom;
	@Column(name="date_de_naissance")
	private Date dateN;
	private String UserAdresse;
	private String email;
	private String MDP;
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public Date getDateN() {
		return dateN;
	}
	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}
	public String getUserAdresse() {
		return UserAdresse;
	}
	public void setUserAdresse(String userAdresse) {
		UserAdresse = userAdresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMDP() {
		return MDP;
	}
	public void setMDP(String mDP) {
		MDP = mDP;
	}
	
	
	
}
