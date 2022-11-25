package com.appetite.appetite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appetite.appetite.dao.iClientRepository;
import com.appetite.appetite.entity.Client;

@Controller
@RequestMapping("/register")
public class ClientController {

    @Autowired
    iClientRepository clientRepository;

    @GetMapping("/new")
    public String displayClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "register/register";
    }

    @PostMapping("/save")
    public String createClient(Client client) {
        clientRepository.save(client);
        return "redirect:/";
    }
}
