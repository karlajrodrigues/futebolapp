package com.futebol.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.futebol.webapp.model.Pessoa;
import com.futebol.webapp.repository.PessoaRepository;
import com.futebol.webapp.service.PessoaService;


@Controller
public class PessoaController {


        @Autowired
        private PessoaRepository pessoaRepository;

        @Autowired
        private PessoaService pessoaService;

         @PostMapping("/salvarPessoas")
        public ResponseEntity<Pessoa> salvarPessoa( @ModelAttribute Pessoa pessoa) {
            
           try{ Pessoa pessoaSaved = pessoaRepository.save(pessoa);
            return ResponseEntity.ok(pessoaSaved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        }

          @GetMapping("/carregarPessoa")
         public ModelAndView carregaEditPessoa() {
            ModelAndView modelAndView = new ModelAndView("/admin/pessoa/edit");
            modelAndView.addObject("pessoa", new Pessoa());
            return modelAndView;
        }



        
    }


        

