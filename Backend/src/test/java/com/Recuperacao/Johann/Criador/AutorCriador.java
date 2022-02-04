package com.Recuperacao.Johann.Criador;

import com.Recuperacao.Johann.models.Autor;

public class AutorCriador {

    public static Autor autorCriador(){
        Autor autor = new Autor(1L,"testeAutor");

        return autor;
    }
}
