package com.futebol.webapp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Time {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="estadio_id") // Jakarta cria na tabela a chave estrangeira estadio _id
    private Estadio estadio;

    
    private String estado;
    private String cidade;
    private String pais;
    private String telefone;

    @Lob // Usado para armazenar grandes objetos (como imagens)
    private byte[] escudo;
    // Getters e Setters
    
   @OneToMany(mappedBy= "time", cascade=CascadeType.ALL, orphanRemoval= true)
   private List<Jogador> jogadores;
    
   @OneToMany(mappedBy="timeCasa")
   private List<Partida> partidasCasa;

   @OneToMany(mappedBy="timeVisitante")
   private List<Partida> partidasVisitante;


}
