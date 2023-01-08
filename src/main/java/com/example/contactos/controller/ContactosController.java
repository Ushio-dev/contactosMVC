package com.example.contactos.controller;

import com.example.contactos.model.Contacto;
import com.example.contactos.service.ContactoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ContactosController {

    ContactoServiceImpl contactoService;

    public ContactosController(ContactoServiceImpl contactoService) {
        this.contactoService = contactoService;
    }
    @GetMapping("/")
    public String holaMundo(Model model) {
        List<Contacto> contactos = contactoService.readAll();
        model.addAttribute("contactos", contactos);
        return "index";
    }
}
