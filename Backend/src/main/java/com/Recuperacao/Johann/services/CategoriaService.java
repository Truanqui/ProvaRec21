package com.Recuperacao.Johann.services;

import com.Recuperacao.Johann.repositories.CategoriaRepository;
import com.Recuperacao.Johann.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> listaCategoria(){
        return categoriaRepository.findAll();
    }
    //FindById
    public Categoria findCategoriaId(Long idCategoria){
        Optional<Categoria> idReturn = categoriaRepository.findById(idCategoria);
        return idReturn.get();
    }
    //Save
    public Categoria saveCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    //Delete
    public void deleteCategoria(Long idCategoria){
        categoriaRepository.deleteById(idCategoria);
    }
    //Edit
    public Categoria editCategoria(Long idCategoria, Categoria idReturn){
        Categoria edCategoria = categoriaRepository.findById(idCategoria).get();
        UpdateInfo(edCategoria, idReturn);
        return categoriaRepository.save(edCategoria);
    }

    public void UpdateInfo(Categoria edCategoria, Categoria idReturn){
        edCategoria.setNomeCategoria(idReturn.getNomeCategoria());
        edCategoria.setDiasCategoria(idReturn.getDiasCategoria());
    }
}
