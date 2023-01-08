package com.example.contactos.controller;

import com.example.contactos.dto.ContactoRequest;
import com.example.contactos.model.Contacto;
import com.example.contactos.service.ContactoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping(value = "/add")
    public String agregar(@ModelAttribute("contacto") ContactoRequest contactoRequest, BindingResult result) {

        contactoService.add(contactoRequest);

        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Contacto> contacto = contactoService.readOne(id);

        model.addAttribute("contacto", contacto.get());

        return "editar";
    }

    @PostMapping("/editar/guardar/{id}")
    public String guardarEdit(@PathVariable Long id, ContactoRequest contactoRequest) {
        Contacto contacto = new Contacto(id, contactoRequest.getNombre(), contactoRequest.getNumero());

        contactoService.actualizar(contacto);

        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        contactoService.eliminarById(id);
        return "redirect:/";
    }
}
