package com.controle.ponto.acesso.usuario.model;

import com.controle.ponto.acesso.categoriausuario.CategoriaUsuario;
import com.controle.ponto.acesso.empresa.model.Empresa;
import com.controle.ponto.acesso.jornadatrabalho.model.JornadaTrabalho;
import com.controle.ponto.acesso.nivelacesso.model.NivelAcesso;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal tolerancia;

    @Column(nullable = false)
    private LocalDateTime inicioJornada;

    @Column(nullable = false)
    private LocalDateTime finalJornada;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private CategoriaUsuario categoriaUsuario;

    @ManyToOne
    private NivelAcesso nivelAcesso;

    @ManyToOne
    private JornadaTrabalho jornadaTrabalho;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    private List<Usuario> movimentacao;
}
