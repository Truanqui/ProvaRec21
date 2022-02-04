package com.Recuperacao.Johann.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    private String nomeCategoria;
    private int diasCategoria;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Livro> livroCategoria = new ArrayList<>();

    public Categoria(){

    }
    public Categoria(Long idCategoria,String nomeCategoria,int diasCategoria){
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.diasCategoria = diasCategoria;

    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getDiasCategoria() {
        return diasCategoria;
    }

    public void setDiasCategoria(int diasCategoria) {
        this.diasCategoria = diasCategoria;
    }

    public List<Livro> getlivroCategoria(){
        return livroCategoria;
    }
}
