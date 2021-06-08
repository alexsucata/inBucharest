package com.alexsucata.inBucharest.controllers;


import com.alexsucata.inBucharest.entities.AuthorityEntity;
import com.alexsucata.inBucharest.entities.UserEntity;
import com.alexsucata.inBucharest.repositories.AuthorityRepository;
import com.alexsucata.inBucharest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public AuthorityRepository authorityRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView("users/users-list");
        modelAndView.addObject("userList", userRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/users/add")
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView("users/register");
        modelAndView.addObject("authorityList", authorityRepository.findAll());
        modelAndView.addObject("userObject", new UserEntity());
        return modelAndView;
    }

    @PostMapping("/users/save")
    public ModelAndView saveUser(@ModelAttribute("userObject") UserEntity userEntity) {
        ModelAndView modelAndView = new ModelAndView("redirect:/users/login");
        userEntity.setEnabled(true);
        Boolean isNewUser = userEntity.getUserId() == null ? true : false;

        if (isNewUser) {
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        }
        if (!isNewUser) {

            if (userEntity.getPassword() != null && !userEntity.getPassword().trim().isEmpty()) {
                userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            } else {
                UserEntity oldUser = userRepository.getOne(userEntity.getUserId());
                userEntity.setPassword(oldUser.getPassword());
            }
        }
        System.out.println(userEntity);
        userEntity = userRepository.save(userEntity);

        if (isNewUser) {
            AuthorityEntity authority = new AuthorityEntity();
            authority.setUsername(userEntity.getUsername());
            authority.setAuthority("USER");
            authority.setUser(userEntity);
            authorityRepository.save(authority);
        }
        return modelAndView;
    }

    public Optional<User> getLoggedInUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            User user = (User) authentication.getPrincipal();
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
