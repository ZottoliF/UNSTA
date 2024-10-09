package com.aprendizaje.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Estudiante extends Usuario {
    @Id
    private String idEstudiante;
    private String nivelConocimiento;
    private String preferenciaAprendizaje;
    private Progreso progreso;

    // Constructor
    public Estudiante(String idUsuario, String nombre, String mail, String contraseña, String tipoUsuario,
                      String idEstudiante, String nivelConocimiento, String preferenciaAprendizaje, Progreso progreso) {
        super(idUsuario, nombre, mail, contraseña, tipoUsuario); 
        this.idEstudiante = idEstudiante;
        this.nivelConocimiento = nivelConocimiento;
        this.preferenciaAprendizaje = preferenciaAprendizaje;
        this.progreso = progreso;
    }

    // Getters y Setters
    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNivelConocimiento() {
        return nivelConocimiento;
    }

    public void setNivelConocimiento(String nivelConocimiento) {
        this.nivelConocimiento = nivelConocimiento;
    }

    public String getPreferenciaAprendizaje() {
        return preferenciaAprendizaje;
    }

    public void setPreferenciaAprendizaje(String preferenciaAprendizaje) {
        this.preferenciaAprendizaje = preferenciaAprendizaje;
    }

    public Progreso getProgreso() {
        return progreso;
    }

    public void setProgreso(Progreso progreso) {
        this.progreso = progreso;
    }
}
