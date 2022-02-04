package com.Recuperacao.Johann.Criador;

import com.Recuperacao.Johann.models.Emprestimo;
import java.time.LocalDate;

public class EmprestimoCriador {

    public static Emprestimo emprestimoCriador(){
        Emprestimo emprestimo = new Emprestimo(1L,LocalDate.now(),LocalDate.now().plusDays(ExemplarCriador.exemplarCriador().getLivro().getCategoria().getDiasCategoria()),Boolean.TRUE,PessoaCriador.pessoaCriador(),ExemplarCriador.exemplarCriador());
        return emprestimo;
    }
}
