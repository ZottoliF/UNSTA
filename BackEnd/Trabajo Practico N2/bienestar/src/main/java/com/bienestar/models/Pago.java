package com.bienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pago {
    
    @Id
    private String id;
    
    private double cantidad;
    private String fecha;

    // Constructor
    public Pago(double cantidad, String fecha) {
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
