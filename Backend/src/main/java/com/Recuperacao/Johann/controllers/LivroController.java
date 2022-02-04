package com.Recuperacao.Johann.controllers;

import com.Recuperacao.Johann.services.LivroService;
import com.Recuperacao.Johann.models.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    LivroService livroService;

    @GetMapping
    public List<Livro> listLivro() {
        return livroService.listaLivro();
    }

    @GetMapping(value = "/{idLivro}")
    public ResponseEntity<Livro> buscaLivroId(@PathVariable Long idLivro) {
        Livro idReturn = livroService.findLivroId(idLivro);
        return ResponseEntity.ok().body(idReturn);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastraLivro(@RequestBody Livro livro) {
        livro = livroService.saveLivro(livro);
        return ResponseEntity.ok().body(livro);
    }

    @PutMapping(value = "/{idLivro}")
    public ResponseEntity<Livro> alterarLivro(@RequestBody Livro livro, @PathVariable Long idLivro) {
        livro = livroService.editLivro(idLivro, livro);
        return ResponseEntity.ok().body(livro);
    }

    @DeleteMapping(value = "/{idLivro}")
    public ResponseEntity<Void> deletaLivro(@PathVariable Long idLivro) {
        livroService.deleteLivro(idLivro);
        return ResponseEntity.noContent().build();
    }
}
