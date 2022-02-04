package com.Recuperacao.Johann.services;

import com.Recuperacao.Johann.repositories.PessoaRepository;
import com.Recuperacao.Johann.models.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> listaPessoa(){
        return pessoaRepository.findAll();
    }
    //FindById
    public Pessoa findPessoaId(Long idPessoa) {
        Optional<Pessoa> idReturn = pessoaRepository.findById(idPessoa);
        return idReturn.get();
    }
    //Save
    public Pessoa savePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    //Delete
    public void deletePessoa(Long pessoaId) {
        pessoaRepository.deleteById(pessoaId);
    }
    //Edit
    public Pessoa editPessoa(Long idPessoa, Pessoa idReturn) {
        Pessoa EdPessoa = pessoaRepository.findById(idPessoa).get();
        UpdateInfo(EdPessoa, idReturn);
        return pessoaRepository.save(EdPessoa);
    }

    private void UpdateInfo(Pessoa EdPessoa, Pessoa idReturn){
        EdPessoa.setNome(idReturn.getNome());
        EdPessoa.setCpf(idReturn.getCpf());
        EdPessoa.setRg(idReturn.getRg());
        EdPessoa.setEmail(idReturn.getEmail());
        EdPessoa.setTelefone(idReturn.getTelefone());
        EdPessoa.setEnderecoResidencial(idReturn.getEnderecoResidencial());
        EdPessoa.setEnderecoComercial(idReturn.getEnderecoComercial());
    }
}
