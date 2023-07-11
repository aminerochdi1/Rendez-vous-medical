package com.ehei.rendezvous.medical.DAO;

import com.ehei.rendezvous.medical.entities.Docteur;
import com.ehei.rendezvous.medical.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;

public interface DocteurRepository  extends JpaRepository<Docteur,Long> {

    @Query(value="select id,adresse,email,nom,prenom,ville,specialite,disponible from Docteur where specialite like :x ",nativeQuery=true)
        public Page<Docteur> chercher(@Param("x") String mc, PageRequest pageable);

}
