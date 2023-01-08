package com.example.contactos.dto;

import lombok.Data;

public class ContactoRequest {
    private String nombre;
    private String numero;

    public ContactoRequest() {
    }

    public ContactoRequest(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
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
}
