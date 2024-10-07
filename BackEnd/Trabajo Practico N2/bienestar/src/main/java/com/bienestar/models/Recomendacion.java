package com.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Recomendacion {
    
    @Id
    private String id;

    private String tipoRecomendacion;
    private String detalle;


    // Constructor
    public Recomendacion(String tipoRecomendacion, String detalle) {
        this.tipoRecomendacion = tipoRecomendacion;
        this.detalle = detalle;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoRecomendacion() {
        return tipoRecomendacion;
    }

    public void setIdMiembro(String tipoRecomendacion) {
        this.tipoRecomendacion = tipoRecomendacion;
    }

    public String getdetalle() {
        return detalle;
    }

    public void setdetalle(String detalle) {
        this.detalle = detalle;
    }
}
