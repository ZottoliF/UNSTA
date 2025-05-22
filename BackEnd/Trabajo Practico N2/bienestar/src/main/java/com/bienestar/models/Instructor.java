package com.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Instructor {
    
    @Id
    private String id;
    
    private String cursosCreados;
    private String especialidad;

    // Constructor
    public Instructor(String cursosCreados, String especialidad) {
        this.cursosCreados = cursosCreados;
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCursosCreados() {
        return cursosCreados;
    }

    public void setCursosCreados(String cursosCreados) {
        this.cursosCreados = cursosCreados;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
