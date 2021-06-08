package com.alexsucata.inBucharest.controllers;


import com.alexsucata.inBucharest.entities.EstablishmentTypeEntity;
import com.alexsucata.inBucharest.repositories.EstablishmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EstablishmentTypeController {

    @Autowired
    public EstablishmentTypeRepository establishmentTypeRepository;

    @GetMapping("/establishment_types")
    public ModelAndView getTypes() {
        ModelAndView modelAndView = new ModelAndView("establishment_types/types-list");
        modelAndView.addObject("establishmentTypeList", establishmentTypeRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/establishment_types/add")
    public ModelAndView addType() {
        ModelAndView modelAndView = new ModelAndView("establishment_types/types-form");
        modelAndView.addObject("establishmentTypeObject", new EstablishmentTypeEntity());
        return modelAndView;
    }

    @PostMapping("establishment_types/save")
    public ModelAndView saveType(@ModelAttribute("establishmentTypeObject") EstablishmentTypeEntity establishmentTypeEntity) {
        ModelAndView modelAndView = new ModelAndView("redirect:/establishment_types");
        establishmentTypeRepository.save(establishmentTypeEntity);
        return modelAndView;
    }

    //No need for edit and delete methods right now!
}
