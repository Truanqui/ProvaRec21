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
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    private String nomeCategoria;
    private String diasCategoria;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Categoria(Categoria entity){
        idCategoria = entity.getIdCategoria();
        nomeCategoria = entity.getNomeCategoria();
        diasCategoria = entity.getDiasCategoria();

    }
}
