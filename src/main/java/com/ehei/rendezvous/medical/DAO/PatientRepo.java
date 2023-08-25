package com.ehei.rendezvous.medical.DAO;

import com.ehei.rendezvous.medical.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient,Long> {


    @Query(value="select id,adresse,cnss,email,nom,prenom,telephone from Patient where nom like :x ",nativeQuery=true)
    public Page<Patient> chercher(@Param("x") String mc, PageRequest pageable);

    @Query(value="select * from Patient where email = :e && password= :p ",nativeQuery=true)
    public boolean Login(@Param("e") String email, @Param("p")String password );

    List<Patient> findByEmail(String email);

    Optional<Patient> findByEmailAndPassword(String email, String password);

}
