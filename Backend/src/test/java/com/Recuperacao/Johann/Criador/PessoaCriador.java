package com.Recuperacao.Johann.Criador;

import com.Recuperacao.Johann.models.Pessoa;

public class PessoaCriador {

    public static Pessoa pessoaCriador(){
        Pessoa pessoa = new Pessoa(1L,"PessoaTeste1","20675123818","82715792","teste@gmail.com","999888777","EnderecoResidencialTeste","EnderecoComercialTeste",true);
        return pessoa;
    }
}
