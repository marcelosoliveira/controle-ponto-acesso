package com.controle.ponto.acesso.nivelacesso.model;

import com.controle.ponto.acesso.localidade.model.Localidade;
import com.controle.ponto.acesso.usuario.model.Usuario;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class NivelAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "nivelAcesso", fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "nivelAcesso", fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    private List<Localidade> localidades;
}
