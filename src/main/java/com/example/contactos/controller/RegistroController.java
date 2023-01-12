package com.example.contactos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistroController {
    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }
}
