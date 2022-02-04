package com.Recuperacao.Johann.controllers;

import com.Recuperacao.Johann.services.EditoraService;
import com.Recuperacao.Johann.models.Editora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/editora")
public class EditoraController {
    @Autowired
    EditoraService editoraService;

    @GetMapping
    public List<Editora> listaEditoras() {
        return editoraService.listaEditora();
    }

    @GetMapping(value = "/{idEditora}")
    public ResponseEntity<Editora> buscaEditoraById(@PathVariable Long idEditora) {
        Editora idReturn = editoraService.findEditoraId(idEditora);
        return ResponseEntity.ok().body(idReturn);
    }

    @PostMapping
    public ResponseEntity<Editora> cadastraEditora(@RequestBody Editora editora) {
        editora = editoraService.saveEditora(editora);
        return ResponseEntity.ok().body(editora);
    }

    @PutMapping(value = "/{idEditora}")
    public ResponseEntity<Editora> alteraEditora(@PathVariable Long idEditora, @RequestBody Editora editora) {
        editora = editoraService.editEditora(idEditora, editora);
        return ResponseEntity.ok().body(editora);
    }

    @DeleteMapping(value = "/{idEditora}")
    public ResponseEntity<Void> deletaEditora(@PathVariable Long idEditora) {
        editoraService.deleteEditora(idEditora);
        return ResponseEntity.noContent().build();
    }
}
