package com.bienestar.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Reserva {
    
    @Id
    private String id;
    
    private String idMiembro;
    private String idInstructor;
    private String idServicio;
    private String idInstalacion;
    private LocalDate fecha;
    private String estado;
    

    // Constructor
    public Reserva(String idMiembro, String idInstructor, String idServicio, String idInstalacion, String estado, LocalDate fecha) {
        this.idMiembro = idMiembro;
        this.idInstructor = idInstructor;
        this.idServicio = idServicio;
        this.idInstalacion = idInstalacion;
        this.fecha = fecha;
        this.estado = estado;
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

    public String getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(String idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(String idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
