package com.ehei.rendezvous.medical.DAO;

import com.ehei.rendezvous.medical.entities.Docteur;
import com.ehei.rendezvous.medical.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RendezVousRepo extends JpaRepository<RendezVous,Long> {


        @Query(value = "SELECT d.nom FROM docteur d " +
                "INNER JOIN rendez_vous r " +
                "WHERE d.id = :id", nativeQuery = true)
        String getNom(long id);

        @Query(value = "SELECT d.ville FROM docteur d " +
                "INNER JOIN rendez_vous r " +
                "WHERE d.id = :id", nativeQuery = true)
        String getVille(long id);

        @Query(value = "SELECT d.specialite FROM docteur d " +
                "INNER JOIN rendez_vous r " +
                "WHERE d.id = :id", nativeQuery = true)
        String getSpecialite(long id);


        RendezVous findRendezVousById(long id);
        List<Docteur> findAllByDocteurId(long id);

}

