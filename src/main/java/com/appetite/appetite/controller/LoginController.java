package com.appetite.appetite.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appetite.appetite.dao.iCheckRepository;
import com.appetite.appetite.entity.Client;

@Controller
@RequestMapping("/")
public class LoginController{

    @GetMapping("/")
    public String displayCheckClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "login/login";
    }

    @Autowired
    iCheckRepository clientCheckRepository;

    Client checkCliend = new Client();
    @PostMapping("/check")
    public String checkClient(Client client) {
        
        // System.out.println("email: " + client.getEmail() + " --- Pass: " + client.getPassword());
        checkCliend = clientCheckRepository.findByEmailAndPassword(client.getEmail(), client.getPassword());

        if(checkCliend != null){
            // System.out.println("Client ID: " + checkCliend.getClientId() + " --- Name: " + checkCliend.getFirstName());
                return "redirect:/home";
            }
        return "redirect:/";
    }


    @RequestMapping("/home")
    public String loadIndexClient(Model model) {
        model.addAttribute("client", checkCliend);
        return "/home/index";
    }

    
    public Client getcheckCliend() {
		return checkCliend;
	}
}
