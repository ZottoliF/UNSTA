package com.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Miembro {
    
    @Id
    private String id;
    
    private String nombre;
    private String email;
    private String historialActividad;

    // Constructor
    public Miembro(String nombre, String email, String historialActividad) {
        this.nombre = nombre;
        this.email = email;
        this.historialActividad = historialActividad;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getTelefono() {
        return historialActividad;
    }

    public void setHistorialActividad(String historialActividad) {
        this.historialActividad = historialActividad;
    }
}
