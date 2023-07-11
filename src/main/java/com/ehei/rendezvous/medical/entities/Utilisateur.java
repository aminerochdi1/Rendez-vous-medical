
package com.ehei.rendezvous.medical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

// ENTITY JPA

@Entity
public class Utilisateur implements Serializable {


    //getter and setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateN() {
        return dateN;
    }

    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Id
    @GeneratedValue
    private long id;
      private String nom;
      private String prenom;
      private Date dateN;
      private String adresse;
      private String mdp;

    public Utilisateur() {

    }

    public Utilisateur(String nom, String prenom, Date dateN, String adresse, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateN = dateN;
        this.adresse = adresse;
        this.mdp = mdp;
    }

}
