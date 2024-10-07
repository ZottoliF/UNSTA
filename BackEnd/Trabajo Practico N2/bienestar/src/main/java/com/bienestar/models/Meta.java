package com.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Meta {
    
    @Id
    private String id;
    
    private String idMiembro;
    private String descripcion;
    private String fechaObjetivo;

    // Constructor
    public Meta(String idMiembro, String descripcion, String fechaObjetivo) {
        this.idMiembro = idMiembro;
        this.descripcion = descripcion;
        this.fechaObjetivo = fechaObjetivo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaObjetivo() {
        return fechaObjetivo;
    }

    public void setFechaObjetivo(String fechaObjetivo) {
        this.fechaObjetivo = fechaObjetivo;
    }
}
