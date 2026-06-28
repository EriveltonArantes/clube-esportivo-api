package com.clubeesportivoapi.repository;

import com.clubeesportivoapi.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {
}
