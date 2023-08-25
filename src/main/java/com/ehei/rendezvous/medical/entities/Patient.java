package com.ehei.rendezvous.medical.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue
   // @Column(name = "Id")
    private long id;

    @NotNull
    @Column(length = 20)
    private String nom;

    @NotNull
    @Column(length = 20)
    private String prenom;


    @NotNull
    @Column(length = 10)
    private int telephone;

    @NotNull
    @Column(length = 50)
    private String adresse;

    @NotNull
    @Column(length = 30)
    private String email;

    @NotNull
    @Column(length = 30)
    private String password;

    public Patient() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @NotNull

    private boolean cnss;

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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
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


    public boolean isCnss() {
        return cnss;
    }

    public void setCnss(boolean cnss) {
        this.cnss = cnss;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public Patient(@NotNull String nom,@NotNull String prenom ,@NotNull int telephone, @NotNull String adresse, @NotNull String email,@NotNull String password , @NotNull boolean cnss) {
        this.nom = nom;
        this.prenom=prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.email = email;
        this.password=password;
        this.cnss = cnss;
    }
}
