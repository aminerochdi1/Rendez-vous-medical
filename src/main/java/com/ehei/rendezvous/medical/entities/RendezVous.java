package com.ehei.rendezvous.medical.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class RendezVous {

    @GeneratedValue
    @Id
    private long id;

    private Date dateRdv;

    @ManyToOne
    @JoinColumn(name = "Id_Doctor")
    private Docteur docteur;


    public RendezVous(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    public RendezVous(LocalDateTime appointmentDateTime, Docteur docteur) {

    }

    public RendezVous() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

}



