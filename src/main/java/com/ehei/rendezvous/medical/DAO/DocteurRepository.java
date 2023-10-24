package com.ehei.rendezvous.medical.DAO;

import com.ehei.rendezvous.medical.entities.Docteur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocteurRepository  extends JpaRepository<Docteur,Long> {

    @Query(value="select id,adresse,email,nom,prenom,ville,specialite,disponible from Docteur where specialite like :x ",nativeQuery=true)
        public Page<Docteur> chercher(@Param("x") String mc, PageRequest pageable);

    @Query(value="select id,adresse,email,nom,prenom,ville,specialite,disponible from Docteur where specialite = :x ",nativeQuery=true)
    // public Page<Docteur> chercherParSpecialite(String mc, PageRequest pageable);
     public Page<Docteur> chercherParSpecialite(@Param("x") String specialite, Pageable pageable);

    @Query(value="select id,adresse,email,nom,prenom,ville,specialite,disponible from Docteur where ville = :x ",nativeQuery=true)
    // public Page<Docteur> chercherParSpecialite(String mc, PageRequest pageable);
    public Page<Docteur> chercherParVille(@Param("x") String specialite, Pageable pageable);

    Docteur findDocteurById(long id);
    //Docteur findOneDocteur(long id);


}
