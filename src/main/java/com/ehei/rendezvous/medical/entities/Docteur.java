package com.ehei.rendezvous.medical.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

@Entity
public class Docteur implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @Column(length = 15)
    private String nom;
    @NotNull
    @Column(length = 15)
    private String prenom;

    @NotNull
    private String Ville;

    @NotNull
    @Column(length = 30)
    private String adresse;
    @NotNull
    private String email;
    @NotNull
    private String specialite;

    // ONE TO MANY
    @OneToMany(mappedBy="docteur",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<RendezVous> rendezVousCollection;

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
