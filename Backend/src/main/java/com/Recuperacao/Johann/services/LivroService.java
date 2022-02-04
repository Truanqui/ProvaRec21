package com.Recuperacao.Johann.services;

import com.Recuperacao.Johann.repositories.LivroRepository;
import com.Recuperacao.Johann.models.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public List<Livro> listaLivro(){
        return livroRepository.findAll();
    }
    //FindById
    public Livro findLivroId(Long idLivro){
        Optional<Livro> idReturn = livroRepository.findById(idLivro);
        return idReturn.get();
    }
    //Save
    public Livro saveLivro(Livro livro){
        return livroRepository.save(livro);
    }
    //Delete
    public void deleteLivro(Long idLivro){
        livroRepository.deleteById(idLivro);
    }
    //Edit
    public Livro editLivro(Long idLivro, Livro idReturn){
        Livro edLivro = livroRepository.findById(idLivro).get();
        UpdateInfo(edLivro, idReturn);
        return livroRepository.save(edLivro);
    }

    private void UpdateInfo(Livro edLivro, Livro idReturn){
        edLivro.setAutor(idReturn.getAutor());
        edLivro.setEditora(idReturn.getEditora());
        edLivro.setNomeLivro(idReturn.getNomeLivro());
    }
}
