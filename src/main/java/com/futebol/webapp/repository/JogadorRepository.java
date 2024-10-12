package com.futebol.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futebol.webapp.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

}
