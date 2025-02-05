package com.futebol.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.futebol.webapp.dto.PartidaCSV;
import com.futebol.webapp.model.Partida;
import com.futebol.webapp.repository.PartidaRepository;
import com.futebol.webapp.service.PartidaService;


@Controller
public class PartidasController {

    @Autowired
    private PartidaRepository partidaRepository;
    @Autowired
    private PartidaService partidaService;


    @GetMapping("/partidas")
    public ModelAndView abrirTelaInicialPartidas() {
        ModelAndView view = new ModelAndView("/admin/partidas/list");
        view.addObject("partidas", partidaRepository.findAll());
        return view;
    }
    
    @GetMapping("/inserirPartida")
    public ModelAndView getMethodName() {
        ModelAndView view = new ModelAndView("/admin/partidas/edit");
        view.addObject("partida", new Partida());
        return view;

    }

    @PostMapping("salvarPartida")
    public ModelAndView salvarPartida(Partida partida) {

        String dataHoraStr = partida.getDataHora().toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        //LocalDateTime  timestamp;
        try {
           // timestamp = new Timestamp(format.parse(dataHoraStr).getTime());
            //partida.setDataHora(timestamp); // Ajusta o valor antes de salvar

            partidaRepository.save(partida);
        } catch (Exception e){
            e.printStackTrace();
        }
       
        ModelAndView modelAndView = new ModelAndView("/admin/partidas/edit");
        modelAndView.addObject("mensagem", "Partida salva com sucesso!");
        return modelAndView;
    }

    @GetMapping("/carregarPartidasCSV")
    public ModelAndView lerPartidasCSV() {
        String caminhoArquivo = "C:\\Users\\igorm\\Documents\\futApp\\futebolapp\\src\\main\\java\\com\\futebol\\webapp\\csv\\partidas.csvv";
        List<PartidaCSV> partidas = partidaService.lerPartidasCSV(caminhoArquivo);
        ModelAndView modelAndView = new ModelAndView("/admin/partidas/listCSV");
        modelAndView.addObject("partidas", partidas);
        return modelAndView;
    }
    
    
    
    
    
}
