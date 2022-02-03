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
@Table(name = "tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;
    private String nomeLivro;
    private String idCategoria;
    private String idEditora;
    private String idAutor;
    private String idAreaDeConhecimentoLivro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEditora")
    private Editora editora;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAutor")
    private Autor autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAreaDeConhecimentoLivro")
    private AreaDeConhecimentoLivro areaDeConhecimentoLivro;

    @JsonIgnore
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Exemplar> exemplares = new ArrayList<>();

    public Livro(Livro entity){
        idLivro = entity.getIdLivro();
        nomeLivro = entity.getNomeLivro();
        categoria = entity.getCategoria();
        editora = entity.getEditora();
        autor = entity.getAutor();
        areaDeConhecimentoLivro = entity.getAreaDeConhecimentoLivro();
    }
}
