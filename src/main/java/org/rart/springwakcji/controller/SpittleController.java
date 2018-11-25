package org.rart.springwakcji.controller;

import org.rart.springwakcji.entity.Spittle;
import org.rart.springwakcji.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING= "9223372036854775807";
          //  Long.toString(Long.MAX_VALUE);
    private SpittleRepository spittleRepository;
    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getSpittles(
            Model model,
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count
            ){

        List<Spittle> spittleList = spittleRepository.findSpittles(Long.MAX_VALUE, count);
        model.addAttribute("spittleList", spittleList);
        return "spittles-page";

    }
    // Kontorler oparty o ścieżkę →
    @RequestMapping(value = "/{spittleId}" , method = RequestMethod.GET)
    public String getSingleSpittle(
            @PathVariable("spittleId") Long spittleId,
            Model theModel
    ){
        Spittle spittle = spittleRepository.findOne(spittleId);
        theModel.addAttribute("spittle" , spittle);
        return "single-spittle";

    }
    /*
    * Przykład ZŁEGO kontrolera
    *   Tego typu zapytania nie powinny być odpytywane za pomocą parametrów
    *  Powinno się pobierać za pomocą ścieżki
    *  Powyższa metoda to reazlizuje
    *
   @RequestMapping(value = "spittle" , method = RequestMethod.GET)
        public String getSingleSpittle(
                    Model theModel,
                    @RequestParam Long spittleId){
            Spittle spittle = spittleRepository.findOne(spittleId);
            theModel.addAttribute("spittle" , spittle);

            return "single-spittle";
    }*/

}
