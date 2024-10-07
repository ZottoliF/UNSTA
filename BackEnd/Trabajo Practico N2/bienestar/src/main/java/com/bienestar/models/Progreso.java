package com.bienestar.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Progreso {

    @Id
    private String id;

    private String idMiembro;
    private String idActividad;
    private String estado;
    private String comentarios;
    private LocalDate fecha;

    // Constructor
    public Progreso(String idMiembro, String idActividad, String estado, String comentarios) {
        this.idMiembro = idMiembro;
        this.idActividad = idActividad;
        this.estado = estado;
        this.comentarios = comentarios;
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

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public LocalDate getFecha() { 
        return fecha;
    }

    public void setFecha(LocalDate fecha) { 
        this.fecha = fecha;
    }
}
