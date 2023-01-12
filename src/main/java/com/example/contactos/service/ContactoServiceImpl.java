package com.example.contactos.service;

import com.example.contactos.dto.ContactoRequest;
import com.example.contactos.model.Contacto;
import com.example.contactos.repository.ContactoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoServiceImpl implements ContactoService{

    private ContactoRepository contactoRepository;

    public ContactoServiceImpl(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }
    @Override
    public List<Contacto> readAll() {
        return contactoRepository.findAll();
    }

    @Override
    public void add(ContactoRequest contactoRequest) {
        Contacto contacto = new Contacto(contactoRequest);
        contactoRepository.save(contacto);
    }

    @Override
    public Optional<Contacto> readOne(Long id) {
        return contactoRepository.findById(id);
    }

    @Override
    public void actualizar(Contacto contacto) {
        contactoRepository.save(contacto);
    }

    @Override
    public void eliminarById(Long id) {
        contactoRepository.deleteById(id);
    }


}
