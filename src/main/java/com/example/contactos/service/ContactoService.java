package com.example.contactos.service;

import com.example.contactos.dto.ContactoRequest;
import com.example.contactos.model.Contacto;

import java.util.List;
import java.util.Optional;

public interface ContactoService {
    List<Contacto> readAll();

    void add(ContactoRequest contactoRequest, String usuario);

    Optional<Contacto> readOne(Long id);

    void actualizar(Contacto contacto);

    void eliminarById(Long id);

    List<Contacto> readAllUserContacts(String user);
}
