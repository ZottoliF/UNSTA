package com.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Instalacion {
    
    @Id
    private String id;

    private String nombre;
    private String tipo;
    private int capacidad;

    // Constructor
    public Instalacion(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() { 
        return capacidad;
    }

    public void setCapacidad(int capacidad) { 
        this.capacidad = capacidad;
    }
}
