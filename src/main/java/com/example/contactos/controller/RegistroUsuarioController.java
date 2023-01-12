package com.example.contactos.controller;

import com.example.contactos.dto.UsuarioRegistroDto;
import com.example.contactos.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {
    private UsuarioService usuarioService;

    public RegistroUsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ModelAttribute(value = "usuario")
    public UsuarioRegistroDto retornarNuevoUsuarioRegistroDto() {
        return  new UsuarioRegistroDto();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDto registroDto) {
        usuarioService.guardar(registroDto);
        return "redirect:/registro?exito";
    }
}
