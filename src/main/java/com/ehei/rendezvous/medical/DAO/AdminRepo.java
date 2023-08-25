package com.ehei.rendezvous.medical.DAO;

import com.ehei.rendezvous.medical.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,Long> {

    Optional<Admin> findAdminByLoginAndPassword(String login, String password);


}

