package com.futebol.webapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futebol.webapp.model.Campeonato;
import com.futebol.webapp.service.CampeonatoService;


@RestController
public class CampeonatoController {

    private final CampeonatoService campeonatoService;

    public CampeonatoController(CampeonatoService campeonatoService) {
        this.campeonatoService = campeonatoService;
    }

    @GetMapping("/campeonatos")
    public List<Campeonato> listarCampeonatos() {
        return campeonatoService.listarCampeonatos();
    }
    

}
