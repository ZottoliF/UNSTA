package com.aprendizaje.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "resultados")
public class Resultado {

    @Id
    private String idResultado;
    private double calificacion;
    private LocalDate fecha;

    // Constructor
    public Resultado(String idResultado, double calificacion, LocalDate fecha) {
        this.idResultado = idResultado;
        this.calificacion = calificacion;
        this.fecha = fecha;
    }

    // Getters y setters
    public String getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(String idResultado) {
        this.idResultado = idResultado;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
