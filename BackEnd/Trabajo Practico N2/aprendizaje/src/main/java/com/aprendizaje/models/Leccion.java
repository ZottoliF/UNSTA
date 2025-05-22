package com.aprendizaje.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "lecciones")
public class Leccion {

    @Id
    private String idLeccion;
    private String nombre;
    private String contenido;
    private List<Evaluacion> evaluaciones;

    // Constructor
    public Leccion(String idLeccion, String nombre, String contenido, List<Evaluacion> evaluaciones) {
        this.idLeccion = idLeccion;
        this.nombre = nombre;
        this.contenido = contenido;
        this.evaluaciones = evaluaciones;
    }

    // Getters y setters
    public String getIdLeccion() {
        return idLeccion;
    }

    public void setIdLeccion(String idLeccion) {
        this.idLeccion = idLeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }
}
