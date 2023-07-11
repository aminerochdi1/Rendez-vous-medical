

package com.ehei.rendezvous.medical.web;

import com.ehei.rendezvous.medical.DAO.DocteurRepository;
import com.ehei.rendezvous.medical.entities.Docteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.ui.Model;

import javax.print.Doc;
import java.awt.print.Pageable;
import java.util.List;

@Controller
public class DocteurController {

    // Injecter un objet de type Docteur
    @Autowired
    private DocteurRepository docteurRepository;

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
            /*
          @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(long id,String Keyword,int page)
    {
        DocteurRepository.delete(id);
           return "redirect:/list?page="+page+"&Keyword="+Keyword;
    }
   */

    @RequestMapping(value="/DoctorForm",method=RequestMethod.GET)
    public String formDocteur(Model model)
    {
        // AJOUT D'UN OBJET
       model.addAttribute("docteur",new Docteur());
        return "register-doctor";
    }
    @RequestMapping(value="/save",method=RequestMethod.POST)
    // DATA BINDING (les donnes en query stocke dans l'objet Docteur )
    public String save(Model model, Docteur doc)
    {
        // AJOUT D'UN OBJET
        docteurRepository.save(doc);
        return "confirm";
    }



}
