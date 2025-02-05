package com.futebol.webapp.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class EstadioPrivado extends Estadio {

    private String dono;   

    private String cnpj;

    private String telefone;

    private String ceo;

    private Double valorEstadio;

    private Double mediaArrecadacao;
}
