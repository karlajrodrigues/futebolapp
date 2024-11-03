package com.futebol.webapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
    
   
    @PostMapping("/salvarTime")
    public ResponseEntity<Time> criarTime(@RequestParam MultipartFile escudo, @ModelAttribute Time time) {
        try {
            if (!escudo.isEmpty()) {
                // Converte o MultipartFile em byte[]
                byte[] escudoBytes = escudo.getBytes();
                time.setEscudo(escudoBytes);
            }
            Time savedTime = timeRepository.save(time);
            return ResponseEntity.ok(savedTime);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/escudo/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getEscudo(@PathVariable Long id) {
        return timeRepository.findById(id)
            .map(time -> ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // ou outro tipo de imagem, dependendo do formato
                .body(time.getEscudo()))
            .orElse(ResponseEntity.notFound().build());
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
