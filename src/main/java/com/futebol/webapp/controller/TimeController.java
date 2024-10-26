package com.futebol.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.futebol.webapp.model.Time;
import com.futebol.webapp.repository.TimeRepository;

@Controller
public class TimeController {
    @Autowired
    private TimeRepository timeRepository;


    

    // Método para buscar todos os times
    @GetMapping("/listarTimes")
    public ModelAndView getTimes() {
        List<Time> listaTimes = timeRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("/admin/time/times");
        modelAndView.addObject("times", listaTimes);
        return modelAndView;
    }

    @GetMapping("/inserirTime")
    public ModelAndView carregaEditTime() {
        ModelAndView modelAndView = new ModelAndView("/admin/time/edit");
        modelAndView.addObject("time", new Time());
        return modelAndView;
    }
    
   
    // Método para criar um novo time
    @PostMapping("/salvarTime")
    public Time criarTime(@RequestBody Time time) {
        return timeRepository.save(time);
    }

    // Método para atualizar um time existente
    @PutMapping("/{id}")
    public ResponseEntity<Time> atualizarTime(@PathVariable Long id, @RequestBody Time timeAtualizado) {
        return timeRepository.findById(id)
            .map(time -> {
                time.setNome(timeAtualizado.getNome());
                time.setCidade(timeAtualizado.getCidade());
                time.setEstadio(timeAtualizado.getEstadio());
                time.setEstado(timeAtualizado.getEstado());
                time.setPais(timeAtualizado.getPais());
                time.setTelefone(timeAtualizado.getTelefone());
                Time timeAtualizadoNoBanco = timeRepository.save(time);
                return ResponseEntity.ok().body(timeAtualizadoNoBanco);
            }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
