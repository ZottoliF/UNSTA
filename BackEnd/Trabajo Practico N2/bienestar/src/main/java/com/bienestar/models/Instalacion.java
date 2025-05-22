package com.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Instalacion {
    
    @Id
    private String id;

    private String nombre;
    private int capacidad;

    // Constructor
    public Instalacion(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
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

    public int getCapacidad() { 
        return capacidad;
    }

    public void setCapacidad(int capacidad) { 
        this.capacidad = capacidad;
    }
}
