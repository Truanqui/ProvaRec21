package com.Recuperacao.Johann.services;

 import com.Recuperacao.Johann.repositories.EmprestimoRepository;
 import com.Recuperacao.Johann.repositories.LivroRepository;
 import com.Recuperacao.Johann.models.Emprestimo;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;
 import java.util.Optional;

@Service
public class EmprestimoService {
    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    LivroService livroService;

    public List<Emprestimo> listaEmprestimo(){
        return emprestimoRepository.findAll();
    }

    //FindById
    public Emprestimo findEmprestimoId(Long idEmprestimo){
        Optional<Emprestimo> idReturn = emprestimoRepository.findById(idEmprestimo);
        return idReturn.get();
    }
    //Save
    public Emprestimo saveEmprestimo(Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }
    //Delete
    public void deleteEmprestimo(Long idEmprestimo){
        Emprestimo emprestimo = emprestimoRepository.getById(idEmprestimo);
        emprestimoRepository.deleteById(idEmprestimo);
    }
}
