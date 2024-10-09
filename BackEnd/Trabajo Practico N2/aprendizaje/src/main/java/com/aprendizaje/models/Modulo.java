package com.aprendizaje.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "modulos")
public class Modulo {

    @Id
    private String idModulo;
    private String nombre;
    private String descripcion;
    private List<Leccion> lecciones;

    // Constructor
    public Modulo(String idModulo, String nombre, String descripcion, List<Leccion> lecciones) {
        this.idModulo = idModulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lecciones = lecciones;
    }

    // Getters y setters
    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Leccion> getLecciones() {
        return lecciones;
    }

    public void setLecciones(List<Leccion> lecciones) {
        this.lecciones = lecciones;
    }
}
