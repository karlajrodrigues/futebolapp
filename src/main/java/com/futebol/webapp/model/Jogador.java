package com.futebol.webapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String posicao;
    private int numeroCamisa;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

    @ManyToMany(mappedBy="jogadores")
    private List<Partida> partidas;

   
}
