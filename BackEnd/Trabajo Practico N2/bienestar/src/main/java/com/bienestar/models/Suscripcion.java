package com.bienestar.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Suscripcion {
    
    @Id
    private String id;

    private String idMiembro;
    private String tipoSuscripcion;
    private LocalDate fechaInicio;
    private String estado;

    // Constructor
    public Suscripcion(String idMiembro, String tipoSuscripcion, LocalDate fechaInicio, String estado) {
        this.idMiembro = idMiembro;
        this.tipoSuscripcion = tipoSuscripcion;
        this.fechaInicio = fechaInicio;
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

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public LocalDate getFechaInicio() { 
        return fechaInicio;
    }

    public void setFechaInicion(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstadp() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
