package com.Recuperacao.Johann.controllers;

import com.Recuperacao.Johann.services.AutorService;
import com.Recuperacao.Johann.models.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/tb_autor")
public class AutorController {

    @Autowired
    AutorService autorService;

    @GetMapping
    public List<Autor> listaAutores() {
        return autorService.listaAutor();
    }

    @GetMapping(value = "/{idAutor}")
    public ResponseEntity<Autor> buscaAutorPorId(@PathVariable Long idAutor) {
        Autor obj = autorService.findAutorId(idAutor);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody Autor autor) {
        autor = autorService.saveAutor(autor);
        return ResponseEntity.ok().body(autor);
    }

    @PutMapping(value = "/{idAutor}")
    public ResponseEntity<Autor> alteraAutor(@RequestBody Autor autor, @PathVariable Long idAutor) {
        autor = autorService.editAutor(idAutor, autor);
        return ResponseEntity.ok().body(autor);
    }


    @DeleteMapping(value = "/{idAutor}")
    public ResponseEntity<Void> deletaAutor(@PathVariable Long idAutor) {
        autorService.deleteAutor(idAutor);
        return ResponseEntity.noContent().build();
    }
}
