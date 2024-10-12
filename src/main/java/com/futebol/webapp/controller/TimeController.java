package com.futebol.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.futebol.webapp.model.Time;
import com.futebol.webapp.repository.TimeRepository;

@RestController
@RequestMapping("/api/times")
public class TimeController {
    @Autowired
    private TimeRepository timeRepository;


    @GetMapping
    public List<Time> getTimes(){
        return timeRepository.findAll();
    }

    @PostMapping
    public Time criarTime(@ResponseBody Time time){
        return timeRepository.save(time);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> atualizarTime(@PathVariable Long id, @RequestBody Time timeAtualizado){
        return timeRepository.findById(id)
        .map(time -> {
            time.setNome(timeAtualizado.getNome());
            time.setCidade(timeAtualizado.getCidade());
            time.setEstadio(timeAtualizado.getEstadio());
            time.setEscudo(timeAtualizado.getEscudo());
            time.setEstado(timeAtualizado.getEstado());
            time.setPais(timeAtualizado.getPais());
            time.setTelefone(timeAtualizado.getTelefone());
            Time timeAtualizadoNoBanco = timeRepository.save(time);
            return ResponseEntity.ok().body(timeAtualizadoNoBanco);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    

}
