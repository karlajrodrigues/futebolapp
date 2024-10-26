package com.futebol.webapp.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Partida {
 @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String estadio;
    private String timeCasa;
    private String timeVisitante;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime  dataHora;

    private String resultado;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEstadio() {
        return estadio;
    }
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
    public String getTimeCasa() {
        return timeCasa;
    }
    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }
    public String getTimeVisitante() {
        return timeVisitante;
    }
    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }
    public LocalDateTime  getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime  dataHora) {
        this.dataHora = dataHora;
    }
    public String getResultado() {
        return resultado;
    }
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    

}
