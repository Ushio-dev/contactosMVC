package com.example.contactos.service;

import com.example.contactos.dto.UsuarioRegistroDto;
import com.example.contactos.model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {
    Usuario guardar(UsuarioRegistroDto usuarioRegistroDto);

    Long findIdByEmail(String email);
}
