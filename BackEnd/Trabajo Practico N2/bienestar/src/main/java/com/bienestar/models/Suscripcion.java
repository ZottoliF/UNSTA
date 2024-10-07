package com.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Suscripcion {
    
    @Id
    private String id;

    private String idMiembro;
    private String tipo;
    private double costo;

    // Constructor
    public Suscripcion(String idMiembro, String tipo) {
        this.idMiembro = idMiembro;
        this.tipo = tipo;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() { 
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}
