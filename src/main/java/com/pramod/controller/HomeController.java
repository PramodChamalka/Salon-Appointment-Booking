package com.pramod.controller;

/*Author : Pramod Chamalka*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String HomeControllerHandler(){
        return "User microService for Saloon booking system";
    }

}
