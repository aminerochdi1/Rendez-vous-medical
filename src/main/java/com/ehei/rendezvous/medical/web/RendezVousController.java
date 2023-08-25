package com.ehei.rendezvous.medical.web;

import com.ehei.rendezvous.medical.DAO.DocteurRepository;
import com.ehei.rendezvous.medical.DAO.RendezVousRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RendezVousController {

    @Autowired
    private RendezVousRepo rendezVousRepo;

    @Autowired
    private DocteurRepository docteurRepository;


    @RequestMapping(value="/booking")
    public String Booking(Model model)
    {
        return "detail-page-2";
    }


    @RequestMapping(value="/book", method=RequestMethod.GET)
    public String FindById(Model model, long id) {
        // GET NOM
        System.out.println("ID: " + id);
        String docNom = rendezVousRepo.getNom(id);
        model.addAttribute("DoctorNom", docNom);
        String docVille = rendezVousRepo.getVille(id);
        model.addAttribute("DoctorVille", docVille);
        String docSpecialite= rendezVousRepo.getSpecialite(id);
        model.addAttribute("DoctorSpecialite", docSpecialite);

        return "detail-page-2";
    }

    // BOOK APPOINTMENT - Handle appointment creation
    @Transactional
    @RequestMapping(value="/saveAppointment",method=RequestMethod.POST)
    public String save(Model model,  RendezVousRepo rdv )
    {

        return "confirm";
    }




}
