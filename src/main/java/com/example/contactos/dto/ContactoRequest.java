package com.example.contactos.dto;

import com.example.contactos.model.Usuario;
import lombok.Data;

public class ContactoRequest {
    private String nombre;
    private String numero;

    private Usuario usuario;
    public ContactoRequest() {
    }

    public ContactoRequest(String nombre, String numero, Usuario usuario) {
        this.nombre = nombre;
        this.numero = numero;
        this.usuario = usuario;
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
