package com.aprendizaje.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
public class Estudiante extends Usuario {
    @Id
    private String idEstudiante;
    private String nivelConocimiento;
    private String preferenciaAprendizaje;
    private Progreso progreso;
    private List<Curso> cursos;  

    // Constructor
    public Estudiante(String idUsuario, String nombre, String mail, String contraseña, String tipoUsuario,
                      String idEstudiante, String nivelConocimiento, String preferenciaAprendizaje, Progreso progreso, List<Curso> cursos) {
        super(idUsuario, nombre, mail, contraseña, tipoUsuario);
        this.idEstudiante = idEstudiante;
        this.nivelConocimiento = nivelConocimiento;
        this.preferenciaAprendizaje = preferenciaAprendizaje;
        this.progreso = progreso;
        this.cursos = cursos;  
    }

    // Getters y setters
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
