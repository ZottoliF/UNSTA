package com.aprendizaje.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "preguntas")
public class Pregunta {

    @Id
    private String idPregunta;
    private String texto;
    private List<String> opciones;

    // Constructor
    public Pregunta(String idPregunta, String texto, List<String> opciones) {
        this.idPregunta = idPregunta;
        this.texto = texto;
        this.opciones = opciones;
    }

    // Getters y setters
    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }
}
