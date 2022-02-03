package com.Recuperacao.Johann.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private String telefone;
    private String enderecoResidencial;
    private String enderecoComercial;
    private String complementoResidencial;
    private String complementoComercial;
    private Long numeroResidencial;
    private Long numeroComercial;


    public Pessoa(Pessoa entity) {
        idPessoa = entity.getIdPessoa();
        nome = entity.getNome();
        cpf = entity.getCpf();
        rg = entity.getRg();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        enderecoResidencial = entity.getEnderecoResidencial();
        enderecoComercial = entity.getEnderecoComercial();
        complementoResidencial = entity.getComplementoResidencial();
        complementoComercial = entity.getComplementoComercial();
        numeroResidencial = entity.getNumeroResidencial();
        numeroComercial = entity.getNumeroComercial();
    }
}
