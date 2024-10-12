package com.futebol.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futebol.webapp.model.Time;

public interface TimeRepository extends JpaRepository<Time, Long> {

}
