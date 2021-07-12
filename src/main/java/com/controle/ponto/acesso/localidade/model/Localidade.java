package com.controle.ponto.acesso.localidade.model;

import com.controle.ponto.acesso.nivelacesso.model.NivelAcesso;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    private NivelAcesso nivelAcesso;
}
