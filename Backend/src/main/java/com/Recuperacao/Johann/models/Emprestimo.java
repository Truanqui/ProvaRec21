package com.Recuperacao.Johann.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;
    private LocalDate dataIncial;
    private LocalDate dataFinal;
    private Boolean emprestado;



    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "emprestimoDeExemplar")
    private Exemplar emprestimoDeExemplar;

    public Emprestimo(){
    }

    public Emprestimo(Long idEmprestimo,LocalDate dataIncial,LocalDate dataFinal,Boolean emprestado,Pessoa pessoa,Exemplar emprestimoDeExemplar){
        this.idEmprestimo = idEmprestimo;
        this.dataIncial = dataIncial;
        this.dataFinal = dataFinal;
        this.emprestado = emprestado;
        this.pessoa = pessoa;
        this.emprestimoDeExemplar = emprestimoDeExemplar;
    }


}
