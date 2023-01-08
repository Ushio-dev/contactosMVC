package com.example.contactos.service;

import com.example.contactos.model.Contacto;
import com.example.contactos.repository.ContactoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
