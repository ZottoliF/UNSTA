package com.aprendizaje.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "evaluaciones")
public class Evaluacion {

    @Id
    private String idEvaluacion;
    private String tipoEvaluacion;
    private List<Pregunta> preguntas;
    private Resultado resultado;

    // Constructor
    public Evaluacion(String idEvaluacion, String tipoEvaluacion, List<Pregunta> preguntas, Resultado resultado) {
        this.idEvaluacion = idEvaluacion;
        this.tipoEvaluacion = tipoEvaluacion;
        this.preguntas = preguntas;
        this.resultado = resultado;
    }

    // Getters y setters
    public String getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(String idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
}
