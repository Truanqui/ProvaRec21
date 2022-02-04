package com.Recuperacao.Johann.services;

import com.Recuperacao.Johann.repositories.EditoraRepository;
import com.Recuperacao.Johann.models.Editora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {
    @Autowired
    EditoraRepository editoraRepository;

    public List<Editora> listaEditora(){
        return editoraRepository.findAll();
    }
    //FindById
    public Editora findEditoraId(Long idEditora){
        Optional<Editora> idReturn = editoraRepository.findById(idEditora);
        return idReturn.get();
    }
    //Save
    public Editora saveEditora(Editora editora){
        return editoraRepository.save(editora);
    }
    //Delete
    public void deleteEditora(Long idEditora){
        editoraRepository.deleteById(idEditora);
    }
    //Edit
    public Editora editEditora(Long idEditora, Editora idReturn){
        Editora edEditora = editoraRepository.findById(idEditora).get();
        UpdateInfo(edEditora, idReturn);
        return editoraRepository.save(edEditora);
    }

    public void UpdateInfo(Editora edEditora, Editora idReturn){
        edEditora.setNomeEditora(idReturn.getNomeEditora());
    }
}
