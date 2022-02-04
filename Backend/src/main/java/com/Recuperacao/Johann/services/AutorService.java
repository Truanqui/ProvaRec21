package com.Recuperacao.Johann.services;
import com.Recuperacao.Johann.repositories.AutorRepository;
import com.Recuperacao.Johann.models.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public List<Autor> listaAutor(){
        return autorRepository.findAll();
    }
    //Find By id
    public Autor findAutorId(Long idAutor){
        Optional<Autor> idReturn = autorRepository.findById(idAutor);
        return idReturn.get();
    }
    //Save
    public Autor saveAutor(Autor autor){
        return autorRepository.save(autor);
    }
    //Delete
    public void deleteAutor(Long idAutor){
        autorRepository.deleteById(idAutor);
    }
    //Edit
    public Autor editAutor(Long idAutor, Autor idReturn){
        Autor edAutor = autorRepository.findById(idAutor).get();
        UpdateInfo(edAutor, idReturn);
        return autorRepository.save(edAutor);
    }

    private void UpdateInfo(Autor entity, Autor idReturn){
        entity.setNomeAutor(idReturn.getNomeAutor());
    }
}
