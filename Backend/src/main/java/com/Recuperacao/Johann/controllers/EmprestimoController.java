package com.Recuperacao.Johann.controllers;

import com.Recuperacao.Johann.services.EmprestimoService;
import com.Recuperacao.Johann.models.Emprestimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    @Autowired
    EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> listaEmprestimo() {
        return emprestimoService.listaEmprestimo();
    }

    @GetMapping(value = "/{idEmprestimo}")
    public ResponseEntity<Emprestimo> buscaEmprestimoId(@PathVariable Long idEmprestimo) {
        Emprestimo obj = emprestimoService.findEmprestimoId(idEmprestimo);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Emprestimo> cadastraEmprestimo(@RequestBody Emprestimo emprestimo) {
        emprestimo = emprestimoService.saveEmprestimo(emprestimo);
        return ResponseEntity.ok().body(emprestimo);
    }

    @DeleteMapping(value = "/{idEmprestimo}")
    public ResponseEntity<Void> deletaEmprestimo(@PathVariable Long idEmprestimo) {
        emprestimoService.deleteEmprestimo(idEmprestimo);
        return ResponseEntity.noContent().build();
    }
}
