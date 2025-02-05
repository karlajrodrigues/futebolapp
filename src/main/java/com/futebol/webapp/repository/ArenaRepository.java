package com.futebol.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futebol.webapp.model.Arena;

public interface ArenaRepository extends  JpaRepository<Arena, Long>{

    boolean existsByNome(String nome);

    Arena findByNome(String mandante);

}
