package com.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Servicio {
    
    @Id
    private String id;

    private String nombre;
    private String tipoServicio;
    private int duracion;
    private Double costo;

    // Constructor
    public Servicio(String nombre, String tipoServicio, int duracion, Double costo) {
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
        this.duracion = duracion;
        this.costo = costo;
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

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
