package com.Recuperacao.Johann.controllers;

import com.Recuperacao.Johann.models.Exemplar;
import com.Recuperacao.Johann.models.Livro;
import com.Recuperacao.Johann.services.ExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/exemplar")
public class ExemplarController {
    @Autowired
    ExemplarService exemplarService;

    @GetMapping
    public List<Exemplar> listExemplar(){
        return exemplarService.listaExemplar();
    }

    @GetMapping(value = "/{idExemplar}")
    public ResponseEntity<Exemplar> buscaExemplarId(@PathVariable Long idExemplar){
        Exemplar idReturn = exemplarService.findExemplarId(idExemplar);
        return ResponseEntity.ok().body(idReturn);
    }

    @PostMapping
    public ResponseEntity<Exemplar> cadastraExemplar(@RequestBody Exemplar exemplar) {
        exemplar = exemplarService.saveExemplar(exemplar);
        return ResponseEntity.ok().body(exemplar);
    }

    @PutMapping(value = "/{idExemplar}")
    public ResponseEntity<Exemplar> alterarExemplar(@RequestBody Exemplar exemplar, @PathVariable Long idExemplar) {
        exemplar = exemplarService.editExemplar(idExemplar, exemplar);
        return ResponseEntity.ok().body(exemplar);
    }

    @DeleteMapping(value = "/{idExemplar}")
    public ResponseEntity<Void> deleteExemplar(@PathVariable Long idExemplar) {
        exemplarService.deleteExemplar(idExemplar);
        return ResponseEntity.noContent().build();
    }
}
