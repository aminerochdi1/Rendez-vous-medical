

package com.ehei.rendezvous.medical.web;

import com.ehei.rendezvous.medical.DAO.DocteurRepository;
import com.ehei.rendezvous.medical.entities.Docteur;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DocteurController {

    // Injecter un objet de type Docteur
    @Autowired
    private DocteurRepository docteurRepository;

    @RequestMapping(value = "/ListFiltre")
    // @ModelAttribute
    public String DoctorsByVille(Model model,String specialite,
                          @RequestParam(name = "page",defaultValue = "0") int p,
                                 @RequestParam(name = "size",defaultValue = "10") int s ,
                          @RequestParam(name = "specialite",defaultValue = "") String mc
    )
    {
        // PAGINATION des docteurs
        Page<Docteur> docteurPage;
        docteurPage = docteurRepository.chercherParSpecialite(specialite,PageRequest.of(p, s));
        System.out.println("--------------------");
        System.out.println("---------la specialite-----------");
        System.out.println(specialite);
        System.out.println("--------------------");
        model.addAttribute("listDocteurs",docteurPage.getContent());
        int[] pages=new int[docteurPage.getTotalPages()];
        model.addAttribute("pages",pages);
        // model.addAttribute("size",s);
        //  model.addAttribute("pageCourante",p);
        //nom de la vue
        return "ListFiltre";
    }

    // FILTRER PAR VILLE

    @RequestMapping(value = "/ListFiltreByVille")
    // @ModelAttribute
    public String DoctorsFilterByVille(Model model,String ville,
                                 @RequestParam(name = "page",defaultValue = "0") int p,
                                 @RequestParam(name = "size",defaultValue = "10") int s ,
                                 @RequestParam(name = "ville",defaultValue = "") String mc
    )
    {
        // PAGINATION des docteurs
        Page<Docteur> docteurPage;
        docteurPage = docteurRepository.chercherParVille(ville,PageRequest.of(p, s));
        System.out.println("--------------------");
        System.out.println("---------la specialite-----------");
        System.out.println(ville);
        System.out.println("--------------------");
        model.addAttribute("listDocteurs",docteurPage.getContent());
        int[] pages=new int[docteurPage.getTotalPages()];
        model.addAttribute("pages",pages);
        // model.addAttribute("size",s);
        //  model.addAttribute("pageCourante",p);
        //nom de la vue
        return "ListFiltre";
    }





    @RequestMapping(value = "/list")
   // @ModelAttribute
    public String Doctors(Model model,
                          @RequestParam(name = "page",defaultValue = "0") int p,
                          @RequestParam(name = "size",defaultValue = "10") int s ,
                          @RequestParam(name = "Keyword",defaultValue = "") String mc
                          )
    {
        // PAGINATION des docteurs
        Page<Docteur> docteurPage;
        docteurPage = docteurRepository.chercher("%"+mc+"%" ,PageRequest.of(p, s));
        model.addAttribute("listDocteurs",docteurPage.getContent());
        int[] pages=new int[docteurPage.getTotalPages()];
        model.addAttribute("pages",pages);
       // model.addAttribute("size",s);
      //  model.addAttribute("pageCourante",p);
        //nom de la vue
        return "list";
    }

        // Methode Delete

    @Transactional
          @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(long id)
    {
        docteurRepository.deleteById(id);
           return "redirect:/list";
    }


    @RequestMapping(value="/DoctorForm",method=RequestMethod.GET)
    public String formDocteur(Model model)
    {
        // AJOUT D'UN OBJET
       model.addAttribute("docteur",new Docteur());
        return "register-doctor";
    }


    //BOOKING-PAGE

    @RequestMapping(value="/ListAdmin")
    public String ListAdmin(Model model,
                          @RequestParam(name = "page",defaultValue = "0") int p,
                          @RequestParam(name = "size",defaultValue = "10") int s ,
                          @RequestParam(name = "Keyword",defaultValue = "") String mc
    )
    {
        // PAGINATION des docteurs
        Page<Docteur> docteurPage;
        docteurPage = docteurRepository.chercher("%"+mc+"%" ,PageRequest.of(p, s));

        model.addAttribute("listDocteurs",docteurPage.getContent());
        int[] pages=new int[docteurPage.getTotalPages()];
        model.addAttribute("pages",pages);
        return "ListAdmin";
    }
    // AJOUTER UN DOCTEUR
    @Transactional
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public String save(Model model,  Docteur doc )
    {
        // AJOUT D'UN OBJET
        if (doc.getId() != 0)
        {
            // Existing doctor, perform update
            docteurRepository.save(doc);
        } else
        {
            // New doctor, perform create
            docteurRepository.saveAndFlush(doc);
        }
        return "confirm";
    }

    // MODIFIER UN DOCTEUR

    @RequestMapping(value="/edit",method=RequestMethod.GET)
    // REDIRECTION
    public String editForm(Model model, Long id, Docteur docteur)
    {
        // AJOUT D'UN OBJET
        Docteur doc=docteurRepository.findDocteurById(id);
        model.addAttribute("docteur",doc);
        //docteurRepository.saveAndFlush(docteur);
        return "EditDoctor";
    }

   //update-doctor



    // BOOKING PAGE
    @RequestMapping(value="/booking-page")
    public String booking(Model model)
    {
          return "booking-page";
    }

}
