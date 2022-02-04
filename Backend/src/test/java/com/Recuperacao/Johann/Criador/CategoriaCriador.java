package com.Recuperacao.Johann.Criador;

import com.Recuperacao.Johann.models.Categoria;
import java.util.HashSet;

public class CategoriaCriador {

    public static Categoria categoriaCriador(){
        Categoria categoria = new Categoria(1L,"testeCategoria",2);
        return categoria;
    }
}
