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
@Table(name = "tb_editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditora;
    private  String nomeEditora;

    @JsonIgnore
    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Editora(Editora entity){
        idEditora = entity.getIdEditora();
        nomeEditora = entity.getNomeEditora();
    }
}
