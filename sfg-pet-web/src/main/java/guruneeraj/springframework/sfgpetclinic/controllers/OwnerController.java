package guruneeraj.springframework.sfgpetclinic.controllers;

import guruneeraj.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"owners","owners/index","owners/index.html"})
    public String getOwners(Model model){
        System.out.println("What is the size of ownerService:" + ownerService.findAll().size());
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }
}
