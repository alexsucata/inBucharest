package com.alexsucata.inBucharest.controllers;


import com.alexsucata.inBucharest.entities.AuthorityEntity;
import com.alexsucata.inBucharest.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorityController {

    @Autowired
    public AuthorityRepository authorityRepository;

    @GetMapping("/authorities")
    ModelAndView getAuthorities() {
        ModelAndView modelAndView = new ModelAndView("authorities/authorities-list");
        modelAndView.addObject("authorityList", authorityRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/authorities/add")
    ModelAndView addAuthority() {
        ModelAndView modelAndView = new ModelAndView("authorities/authorities-form");
        modelAndView.addObject("authorityObject", new AuthorityEntity());
        return modelAndView;
    }

    @PostMapping("/authorities/save")
    public ModelAndView saveAuthority(@ModelAttribute("authorityObject") AuthorityEntity authorityEntity) {
        ModelAndView modelAndView = new ModelAndView("redirect:/authorities/add");
        authorityRepository.save(authorityEntity);
        return modelAndView;
    }


}
