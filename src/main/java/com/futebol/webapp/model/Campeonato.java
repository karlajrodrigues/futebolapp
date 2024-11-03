package com.futebol.webapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Campeonato {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
