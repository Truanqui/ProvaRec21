package com.Recuperacao.Johann.services;

import com.Recuperacao.Johann.repositories.ExemplarRepository;
import com.Recuperacao.Johann.repositories.LivroRepository;
import com.Recuperacao.Johann.models.Exemplar;
import com.Recuperacao.Johann.models.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExemplarService {
    @Autowired
    ExemplarRepository exemplarRepository;

    public List<Exemplar> listaExemplar(){
        return exemplarRepository.findAll();
    }
    //FindById
    public Exemplar findExemplarId(Long idExemplar){
        Optional<Exemplar> idReturn = exemplarRepository.findById(idExemplar);
        return idReturn.get();
    }
    //Save
    public Exemplar saveExemplar(Exemplar exemplar){
        return exemplarRepository.save(exemplar);
    }
    //Delete
    public void deleteExemplar(Long idExemplar){
        exemplarRepository.deleteById(idExemplar);
    }
    //Edit
    public Exemplar editExemplar(Long idExemplar, Exemplar idReturn){
        Exemplar edExemplar = exemplarRepository.findById(idExemplar).get();
        UpdateInfo(edExemplar, idReturn);
        return exemplarRepository.save(edExemplar);
    }

    public void UpdateInfo(Exemplar edExemplar, Exemplar idReturn){
        edExemplar.setLivro(idReturn.getLivro());
    }
}
