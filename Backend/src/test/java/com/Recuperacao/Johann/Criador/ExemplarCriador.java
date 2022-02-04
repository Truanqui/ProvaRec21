package com.Recuperacao.Johann.Criador;

import com.Recuperacao.Johann.models.Exemplar;
import com.Recuperacao.Johann.models.Livro;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ExemplarCriador {

    public static List<Exemplar> exemplarListaCriar(){

        List<Exemplar> exemplaresLista = new ArrayList<>();
        Exemplar exemplar1 = new Exemplar(1L, LivroCriador.livroCriador());
        Exemplar exemplar2 = new Exemplar(2L, LivroCriador.livroCriador());;
        Exemplar exemplar3 = new Exemplar(3L, LivroCriador.livroCriador());;
        Exemplar exemplar4 = new Exemplar(4L, LivroCriador.livroCriador());;

        exemplaresLista.add(exemplar1);
        exemplaresLista.add(exemplar2);
        exemplaresLista.add(exemplar3);
        exemplaresLista.add(exemplar4);

        return exemplaresLista;
    }

    public static Exemplar exemplarCriador(){
        Exemplar exemplar = new Exemplar(1L,LivroCriador.livroCriador());
        return exemplar;
    }
}
