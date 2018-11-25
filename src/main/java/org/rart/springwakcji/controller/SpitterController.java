package org.rart.springwakcji.controller;

import org.rart.springwakcji.entity.Spitter;
import org.rart.springwakcji.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String getRegistationForm(){
        return "register-page";
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String processRegistration(Spitter spitter){
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getLogin();
    }

    @RequestMapping(value = "/{login}" , method =  GET)
    public String showSpitterProfile(
            @PathVariable String login , Model model
    ){
        Spitter spitter = spitterRepository.findByLogin(login);
        model.addAttribute(spitter);
        return "profile";
    }

}
