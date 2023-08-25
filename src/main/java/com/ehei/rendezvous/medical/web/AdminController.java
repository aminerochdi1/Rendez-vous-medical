package com.ehei.rendezvous.medical.web;

import com.ehei.rendezvous.medical.DAO.AdminRepo;
import com.ehei.rendezvous.medical.entities.Admin;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private AdminRepo adminRepo;

    
    @RequestMapping(value="/authentificateAdmin",method= RequestMethod.GET)
    public String authentificateAdmin(@RequestParam("login") String login, @RequestParam("password") String password, HttpSession session) {
        Optional<Admin> optionalPatient = adminRepo.findAdminByLoginAndPassword(login, password);

        if (optionalPatient.isPresent()) {
            // Patient found, perform login logic here
            Admin admin = optionalPatient.get();
            session.setAttribute("loggedInAdmin", adminRepo);
            return "redirect:/ListAdmin"; // Redirect to the dashboard or desired page
        }
        return "loginAdmin";
    }



    @RequestMapping(value="/loginAdmin")
    public String LoginFormAdmin(Model model)
    {
        return "loginAdmin";
    }



}
