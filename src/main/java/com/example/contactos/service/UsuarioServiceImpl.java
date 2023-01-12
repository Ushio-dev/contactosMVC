package com.example.contactos.service;

import com.example.contactos.dto.UsuarioRegistroDto;
import com.example.contactos.model.Rol;
import com.example.contactos.model.Usuario;
import com.example.contactos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    @Lazy
    private BCryptPasswordEncoder passwordEncoder;
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario guardar(UsuarioRegistroDto usuarioRegistroDto) {
        Usuario usuario = new Usuario(usuarioRegistroDto.getNombre(),
                usuarioRegistroDto.getEmail(),
                passwordEncoder.encode(usuarioRegistroDto.getPassword()),
                Arrays.asList(new Rol("ROL_USER")));

        return usuarioRepository.save(usuario);
    }

    @Override
    public Long findIdByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Usuario usuario = usuarioRepository.findByEmail(username);

        if (usuario == null) {
            System.out.println("Error usuarios");
            throw new UsernameNotFoundException("Usuario o Password invalidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRol())).collect(Collectors.toList());
    }
}
