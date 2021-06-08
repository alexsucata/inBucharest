package com.alexsucata.inBucharest.controllers;


import com.alexsucata.inBucharest.repositories.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    public EstablishmentRepository establishmentRepository;

    @GetMapping("/index")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("myLogo", "inBucharest");
        modelAndView.addObject("establishments", establishmentRepository.findAll());
        return modelAndView;
    }

}
