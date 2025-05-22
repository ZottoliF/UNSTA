package com.bienestar.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Progreso {

    @Id
    private String id;

    private String tipoActividad;
    private String resultado;
    private LocalDate fecha;

    // Constructor
    public Progreso(String tipoActividad, String resultado, LocalDate fecha) {
        this.tipoActividad = tipoActividad;
        this.resultado = resultado;
        this.fecha = fecha;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDate getFecha() { 
        return fecha;
    }

    public void setFecha(LocalDate fecha) { 
        this.fecha = fecha;
    }
}
