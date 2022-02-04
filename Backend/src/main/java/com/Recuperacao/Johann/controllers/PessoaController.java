package com.Recuperacao.Johann.controllers;

import com.Recuperacao.Johann.services.PessoaService;
import com.Recuperacao.Johann.models.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listaPessoa() {
        return pessoaService.listaPessoa();
    }

    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<Pessoa> buscaPessoaId(@PathVariable Long idPessoa) {
        Pessoa idReturn = pessoaService.findPessoaId(idPessoa);
        return ResponseEntity.ok().body(idReturn);
    }

    @PostMapping
    public ResponseEntity<Pessoa> cadastraPessoa (@RequestBody Pessoa pessoa){
        pessoa = pessoaService.savePessoa(pessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    @PutMapping(value = "/{idPessoa}")
    public ResponseEntity<Pessoa> alteraUsuario(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa){
        pessoa = pessoaService.editPessoa(idPessoa, pessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    @DeleteMapping(value = "/{idPessoa}")
    public ResponseEntity<Void> deletaPessoa(@PathVariable Long idPessoa) {
        pessoaService.deletePessoa(idPessoa);
        return ResponseEntity.noContent().build();
    }
}
