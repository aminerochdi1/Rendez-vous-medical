package com.ehei.rendezvous.medical.web;

import com.ehei.rendezvous.medical.DAO.PatientRepo;
import com.ehei.rendezvous.medical.entities.Patient;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class PatientController {

    @Autowired
    private PatientRepo patientRepo;

    // S'INSCRIRE
    @RequestMapping(value="/SignUp",method= RequestMethod.POST)
    // DATA BINDING (les donnes en query stocke dans l'objet Docteur )

    // POUR STOCKER LES ERREURS AVEC 'BindingResult'
    public String SignUp(Model model,  Patient patient )
    {
        // AJOUT D'UN OBJET
        patientRepo.save(patient);
        return "confirm";
    }





    @RequestMapping(value="/authentificate",method= RequestMethod.GET)
    public String login(String email, String password, HttpSession session) {
        Optional<Patient> optionalPatient = patientRepo.findByEmailAndPassword(email, password);

        if (optionalPatient.isPresent()) {
            // Patient found, perform login logic here
            Patient patient = optionalPatient.get();
            session.setAttribute("loggedInPatient", patient);
            return "redirect:/list"; // Redirect to the dashboard or desired page
            }
           return "patientLogin";
    }



    /*
    @RequestMapping(value="/logout",method= RequestMethod.GET)
    public String LogOut(HttpSession session) {
        Optional<Patient> optionalPatient = patientRepo.findByEmailAndPassword(email, password);
        Patient patient = optionalPatient.get();
        session.removeAttribute("loggedInPatient",patient);
    }

  */

    @RequestMapping(value="/patientLogin")
    public String LoginForm(Model model)
    {
        return "patientLogin";
    }

    @RequestMapping(value="/PatientRegister")
    public String registerPatientForm(Model model)
    {
        return "redirect:/register";
    }

}
