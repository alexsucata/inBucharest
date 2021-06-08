package com.alexsucata.inBucharest.controllers;


import com.alexsucata.inBucharest.entities.EstablishmentEntity;
import com.alexsucata.inBucharest.entities.EstablishmentTypeEntity;
import com.alexsucata.inBucharest.repositories.EstablishmentRepository;
import com.alexsucata.inBucharest.repositories.EstablishmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EstablishmentController {

    @Autowired
    public EstablishmentRepository establishmentRepository;

    @Autowired
    public EstablishmentTypeRepository establishmentTypeRepository;

    @GetMapping("/establishments")
    public ModelAndView getEstablishments() {
        ModelAndView modelAndView = new ModelAndView("establishments/list");
        modelAndView.addObject("establishmentList", establishmentRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/establishments/add")
    public ModelAndView addEstablishment() {
        ModelAndView modelAndView = new ModelAndView("establishments/form");
        modelAndView.addObject("establishmentTypeList", establishmentTypeRepository.findAll());
        modelAndView.addObject("establishmentObject", new EstablishmentEntity());
        return modelAndView;
    }

    @PostMapping("/establishments/save")
    public ModelAndView saveEstablishment(@ModelAttribute("establishmentObject") EstablishmentEntity establishmentEntity) {
        ModelAndView modelAndView = new ModelAndView("redirect:/establishments");
        establishmentRepository.save(establishmentEntity);
        return modelAndView;
    }

    @GetMapping("/establishments/edit/{establishmentId}")
    public ModelAndView editEstablishment(@PathVariable Integer establishmentId) {
        ModelAndView modelAndView = new ModelAndView("establishments/form");
        modelAndView.addObject("establishmentObject", establishmentRepository.findById(establishmentId).get());
        modelAndView.addObject("establishmentList", establishmentRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/establishments/delete/{establishmentId}")
    public ModelAndView deleteEstablishment(@PathVariable Integer establishmentId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/establishments");
        establishmentRepository.deleteById(establishmentId);
        return modelAndView;
    }


}
