package com.controle.ponto.acesso.calendario.model;

import com.controle.ponto.acesso.movimentacao.model.Movimentacao;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataEspecial;

    @OneToMany(mappedBy = "calendario", fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    private List<Movimentacao> movimentacao;
}
