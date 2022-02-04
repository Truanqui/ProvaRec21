package com.Recuperacao.Johann.Criador;

import com.Recuperacao.Johann.models.Livro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LivroCriador {
    public static Livro livroCriador(){
        Livro livro = new Livro(1L,"Diario de um banana", CategoriaCriador.categoriaCriador(),EditoraCriador.editoraCriador(),AutorCriador.autorCriador());
        return livro;
    }
}
