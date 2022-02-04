package com.Recuperacao.Johann.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@Entity
@Table(name = "tb_exemplar")
public class Exemplar implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExemplar;

    @ManyToOne
    @JoinColumn(name = "idLivro")
    private Livro livro;

    @JsonIgnore
    @OneToMany(mappedBy ="emprestimoDeExemplar",cascade = CascadeType.ALL)
    private List<Emprestimo> listaEmprestimo = new ArrayList<>();

    public Exemplar(){
    }

    public Exemplar(Long idExemplar,Livro livro){
        this.idExemplar = idExemplar;
        this.livro = livro;
    }

    public Long getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(Long idExemplar) {
        this.idExemplar = idExemplar;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public List<Emprestimo> getListaEmprestimo(){
        return listaEmprestimo;
    }
}
