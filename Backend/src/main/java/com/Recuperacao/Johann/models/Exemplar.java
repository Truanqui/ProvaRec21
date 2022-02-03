package com.Recuperacao.Johann.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_exemplar")
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExemplar;
    private String nomeExemplar;
    private Long dataInicialExemplar;
    private Long dataFinalExemplar;
    private Long emprestimo;

    private Long idLivro;
    private Long idPessoa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idLivro")
    private Livro livro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    public Exemplar(Exemplar entity){
        idExemplar = entity.getIdExemplar();
        nomeExemplar = entity.getNomeExemplar();
        dataInicialExemplar = entity.getDataInicialExemplar();
        dataFinalExemplar = entity.getDataFinalExemplar();
        emprestimo = entity.getEmprestimo();
        livro = entity.getLivro();
        pessoa = entity.getPessoa();
    }
}
