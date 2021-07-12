package com.controle.ponto.acesso.jornadatrabalho.repository;

import com.controle.ponto.acesso.jornadatrabalho.model.JornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface JornadaRepository extends JpaRepository<JornadaTrabalho, Long> {
}
