package com.aprendizaje.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
public class Instructor extends Usuario {
    @Id
    private String idInstructor;
    private String especialidad;
    private List<Curso> cursosCreados;

    // Constructor
    public Instructor(String idUsuario, String nombre, String mail, String contraseña, String tipoUsuario,
                      String idInstructor, String especialidad, List<Curso> cursosCreados) {
        super(idUsuario, nombre, mail, contraseña, tipoUsuario);
        this.idInstructor = idInstructor;
        this.especialidad = especialidad;
        this.cursosCreados = cursosCreados;
    }

    // Getters y Setters
    public String getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(String idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Curso> getCursosCreados() {
        return cursosCreados;
    }

    public void setCursosCreados(List<Curso> cursosCreados) {
        this.cursosCreados = cursosCreados;
    }
}
