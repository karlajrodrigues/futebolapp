package com.futebol.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.futebol.webapp.model.Arena;
import com.futebol.webapp.service.ImportacaoService;

@Controller
public class ImportacaoController {

    @Autowired
    private ImportacaoService importacaoService;
    

    @GetMapping("/importarArena")
    public ModelAndView getMethodName() {
        String caminhoArquivo = "C:\\Users\\Karla\\Desktop\\Igor\\futebolwebapp\\webapp\\src\\main\\java\\com\\futebol\\webapp\\csv\\partidas.csv";
        List<Arena> arenas = importacaoService.importarArena(caminhoArquivo);
        ModelAndView modelAndView = new ModelAndView("/admin/arena/list");
        modelAndView.addObject("mensagem", "Arenas foram importadas com sucesso!");
        modelAndView.addObject("arenas", arenas);
        return modelAndView;
       
        
    }
}
