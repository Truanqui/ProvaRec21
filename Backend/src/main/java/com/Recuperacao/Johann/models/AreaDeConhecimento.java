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
@Table(name = "tb_area_de_conhecimento")
public class AreaDeConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAreaDeConhecimento;

    private String nomeAreaDeConhecimento;

    @JsonIgnore
    @OneToMany(mappedBy = "area_de_conhecimeto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AreaDeConhecimentoLivro> areaDeConhecimentoLivros = new ArrayList<>();

    public AreaDeConhecimento(AreaDeConhecimento entity){
        idAreaDeConhecimento = entity.getIdAreaDeConhecimento();
        nomeAreaDeConhecimento = entity.getNomeAreaDeConhecimento();
    }
}
