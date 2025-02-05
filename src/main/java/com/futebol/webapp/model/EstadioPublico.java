package com.futebol.webapp.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class EstadioPublico extends Estadio{
    private String prefeituraResponsavel;
    

}
