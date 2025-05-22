package com.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Meta {
    
    @Id
    private String id;
    
    private String metas;
    private String progreso;
    private String historialActividad;

    // Constructor
    public Meta(String metas, String progreso, String historialActividad) {
        this.metas = metas;
        this.progreso = progreso;
        this.historialActividad = historialActividad;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMetas() {
        return metas;
    }

    public void setMetas(String metas) {
        this.metas = metas;
    }

    public String getProgreso() {
        return progreso;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }

    public String getHistorialActividad() {
        return historialActividad;
    }

    public void setHistorialActividad(String historialActividad) {
        this.historialActividad = historialActividad;
    }
}
