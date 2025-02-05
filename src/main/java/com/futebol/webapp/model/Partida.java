package com.futebol.webapp.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Partida {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="estadio_id")
    private Estadio estadio;

    @ManyToOne
    @JoinColumn(name="time_casa_id")
    private Time timeCasa;

    @ManyToOne
    @JoinColumn(name="time_visitante_id")
    private Time timeVisitante;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime  dataHora;

    private String resultado;
    
    @ManyToMany
    @JoinTable(name="partida_jogador", 
    joinColumns=@JoinColumn(name="partida_id"),
    inverseJoinColumns=@JoinColumn(name="jogador_id"))
    private List<Jogador> jogadores;

}
