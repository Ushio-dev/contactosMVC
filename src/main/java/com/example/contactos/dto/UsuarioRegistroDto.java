package com.example.contactos.dto;

public class UsuarioRegistroDto {
    private Long id;
    private String nombre;
    private String email;
    private String password;

    public UsuarioRegistroDto() {
    }

    public UsuarioRegistroDto(String email) {
        this.email = email;
    }

    public UsuarioRegistroDto(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDto(Long id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
