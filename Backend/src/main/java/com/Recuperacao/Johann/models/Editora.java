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
@Table(name = "tb_editora")
public class Editora implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditora;
    private  String nomeEditora;

    @JsonIgnore
    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
    private List<Livro> livroEditora = new ArrayList<>();

    public Editora(){
    }

    public Editora(Long idEditora, String nomeEditora){
        this.idEditora = idEditora;
        this.nomeEditora = nomeEditora;
    }

    public Long getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Long idEditora) {
        this.idEditora = idEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public List<Livro> getlivroEditora(){
        return livroEditora;
    }
}
