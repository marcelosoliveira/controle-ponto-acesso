package com.controle.ponto.acesso.movimentacao.model;

import com.controle.ponto.acesso.calendario.model.Calendario;
import com.controle.ponto.acesso.ocorrencia.model.Ocorrencia;
import com.controle.ponto.acesso.usuario.model.Usuario;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movimentacao {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private LocalDateTime dataEntrada;

        @Column(nullable = false)
        private LocalDateTime dataSaida;

        @Column(nullable = false)
        private BigDecimal periodo;

        @ManyToOne
        private Usuario usuario;

        @ManyToOne
        private Ocorrencia ocorrencia;

        @ManyToOne
        private Calendario calendario;

        @OneToMany(mappedBy = "movimentacao", fetch = FetchType.LAZY,
                cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
        private List<Usuario> bancoHoras;
}


