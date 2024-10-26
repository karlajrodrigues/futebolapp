package com.futebol.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futebol.webapp.model.Partida;

public interface PartidaRepository extends JpaRepository<Partida, Long>  {

}
