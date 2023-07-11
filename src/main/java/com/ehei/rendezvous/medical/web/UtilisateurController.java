package com.ehei.rendezvous.medical.web;

import com.ehei.rendezvous.medical.DAO.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtilisateurController {

    // Injecter un objet de type Utilisateur

     @Autowired
     private UtilisateurRepository utilisateurRepository;

     @RequestMapping(value = "/index")
     public String index()
     {
          //nom de la vue
          return "index";
     }

     @RequestMapping(value = "/register")
     public String Register()
     {
         //nom de la vue
         return "register";
     }












}
