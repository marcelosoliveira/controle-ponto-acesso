package com.controle.ponto.acesso.jornada.repository;

import com.controle.ponto.acesso.jornada.model.Jornada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface JornadaRepository extends JpaRepository<Jornada, Long> {
}
