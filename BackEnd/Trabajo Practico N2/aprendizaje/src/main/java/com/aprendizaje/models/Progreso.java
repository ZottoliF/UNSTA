package com.aprendizaje.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "progresos")
public class Progreso {

    @Id
    private String idProgreso;
    private int leccionesCompletadas;
    private double porcentajeAvance;
    private List<Resultado> calificaciones;

    // Constructor 
    public Progreso(String idProgreso, int leccionesCompletadas, double porcentajeAvance, List<Resultado> calificaciones) {
        this.idProgreso = idProgreso;
        this.leccionesCompletadas = leccionesCompletadas;
        this.porcentajeAvance = porcentajeAvance;
        this.calificaciones = calificaciones;
    }

    // Getters y setters
    public String getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(String idProgreso) {
        this.idProgreso = idProgreso;
    }

    public int getLeccionesCompletadas() {
        return leccionesCompletadas;
    }

    public void setLeccionesCompletadas(int leccionesCompletadas) {
        this.leccionesCompletadas = leccionesCompletadas;
    }

    public double getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(double porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }

    public List<Resultado> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Resultado> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
