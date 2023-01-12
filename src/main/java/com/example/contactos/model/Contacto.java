package com.example.contactos.model;

import com.example.contactos.dto.ContactoRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;

@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String numero;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    public Contacto() {
    }

    public Contacto(Long id, String nombre, String numero) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
    }

    public Contacto(Long id, String nombre, String numero, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.usuario = usuario;
    }

    public Contacto(ContactoRequest contactoRequest) {
        this.nombre = contactoRequest.getNombre();
        this.numero = contactoRequest.getNumero();
        this.usuario = contactoRequest.getUsuario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
