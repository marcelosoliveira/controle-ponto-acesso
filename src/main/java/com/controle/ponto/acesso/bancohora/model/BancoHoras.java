package com.controle.ponto.acesso.bancohora.model;

import com.controle.ponto.acesso.movimentacao.model.Movimentacao;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BancoHoras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataTrabalhada;

    @Column(nullable = false)
    private BigDecimal quantidadeHoras;

    @Column(nullable = false)
    private BigDecimal saldoHoras;

    @ManyToOne
    private Movimentacao movimentacao;

}
