package com.ehei.rendezvous.medical.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.ColumnDefault;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity
public class Docteur implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private String prenom;

    public Boolean getDisponible() {
        return Disponible;
    }

    public void setDisponible(Boolean disponible) {
        Disponible = disponible;
    }

    @ColumnDefault("true")
    @NotNull
    private Boolean Disponible;

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    private String Ville;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    private String adresse;
    private String email;
    private String specialite;


    public Docteur() {
    }

    public Docteur(String nom, String prenom, String Ville,String adresse, String email, String specialite, Boolean Disponible) {
        this.nom = nom;
        this.prenom = prenom;
        this.Ville=Ville;
        this.adresse = adresse;
        this.email = email;
        this.specialite = specialite;
        this.Disponible=Disponible;
    }
}
