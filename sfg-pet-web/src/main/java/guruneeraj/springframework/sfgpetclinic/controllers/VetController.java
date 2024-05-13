package guruneeraj.springframework.sfgpetclinic.controllers;

import guruneeraj.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"vets","vets/index","vets/index.html"})
    public String getVets(Model model){
        System.out.println("What is the size of verService:" + vetService.findAll().size());
            model.addAttribute("owners",vetService.findAll());
        return "vets/index";
    }
}
