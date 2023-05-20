package com.ehei.rendezvousmedical.model;

import java.sql.Date;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;

@Entity
// ON ANNOTE LES ATTRIBUTS UNIQUE AVEC CET ANNOTATION
@Table(name="utilisateur",uniqueConstraints= @UniqueConstraint(columnNames="email"))
public class Utilisateur {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) // POUR GéNERER LE L'ID AUTOMATIQUEMENTS
	private int id;
	
	@Column(name="nom")
	private String Nom;
	@Column(name="prenom")
	private String Prenom;
	@Column(name="date_de_naissance")
	private Date dateN;
	private String UserAdresse;
	private String email;
	private String MDP;
	
	// MANY TO MANY RELATIONSHIP
		//WITH EAGER THE MOMENT WE RETRIEVE A USER WE RETRIEVE HIS ROLE
	@ManyToMany(fetch= FetchType.EAGER,cascade=CascadeType.ALL) 
	@JoinTable(
			name="utilisateurs_roles",
			joinColumns= @JoinColumn(
					name="utilisateur_id",referencedColumnName="id"),
			inverseJoinColumns= @JoinColumn(
					name="role_id",referencedColumnName="id")
					)
	private Collection<Role> roles;
	
	public Utilisateur(String nom, String prenom, Date dateN, String userAdresse, String email, String mDP,
			Collection<Role> roles) {
		super();
		Nom = nom;
		Prenom = prenom;
		this.dateN = dateN;
		UserAdresse = userAdresse;
		this.email = email;
		MDP = mDP;
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
