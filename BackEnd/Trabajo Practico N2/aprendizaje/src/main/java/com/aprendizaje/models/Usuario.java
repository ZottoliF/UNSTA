package com.aprendizaje.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {
    @Id
    private String idUsuario;
    private String nombre;
    private String mail;
    private String contraseña;
    private String tipoUsuario; 


    // Constructor
    public Usuario(String idUsuario, String nombre, String mail, String contraseña, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.mail = mail;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y Setters
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
