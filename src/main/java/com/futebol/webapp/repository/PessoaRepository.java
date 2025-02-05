package com.futebol.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futebol.webapp.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {



}
