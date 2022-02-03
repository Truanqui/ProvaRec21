package com.Recuperacao.Johann.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_area_de_conhecimento_livro")
public class AreaDeConhecimentoLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAreaDeConhecimentoLivro;
    private String nomeAreaDeConhecimentoLivro;
    private Long idAreaDeConhecimento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAreaDeConhecimento")
    private AreaDeConhecimento areaDeConhecimento;

    @JsonIgnore
    @OneToMany(mappedBy = "area_de_conhecimeto_livro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public AreaDeConhecimentoLivro(AreaDeConhecimentoLivro entity){
        idAreaDeConhecimentoLivro = entity.getIdAreaDeConhecimentoLivro();
        nomeAreaDeConhecimentoLivro = entity.getNomeAreaDeConhecimentoLivro();
        areaDeConhecimento = entity.getAreaDeConhecimento();
    }
}
