package com.example.contactos.service;

import com.example.contactos.dto.ContactoRequest;
import com.example.contactos.model.Contacto;
import com.example.contactos.model.Usuario;
import com.example.contactos.repository.ContactoRepository;
import com.example.contactos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoServiceImpl implements ContactoService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    private ContactoRepository contactoRepository;

    public ContactoServiceImpl(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }
    @Override
    public List<Contacto> readAll() {
        return contactoRepository.findAll();
    }

    @Override
    public void add(ContactoRequest contactoRequest, String usuario) {
        Usuario us = usuarioRepository.findByEmail(usuario);
        contactoRequest.setUsuario(us);
        Contacto contacto = new Contacto(contactoRequest);
        contactoRepository.save(contacto);
    }

    @Override
    public Optional<Contacto> readOne(Long id) {
        return contactoRepository.findById(id);
    }

    @Override
    public void actualizar(Contacto contacto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(currentPrincipalName);
        contacto.setUsuario(usuario);
        contactoRepository.save(contacto);
    }

    @Override
    public void eliminarById(Long id) {
        contactoRepository.deleteById(id);
    }

    @Override
    public List<Contacto> readAllUserContacts(String user) {
        Usuario usuario = usuarioRepository.findByEmail(user);
        return contactoRepository.findAllById(usuario.getId());
    }


}
