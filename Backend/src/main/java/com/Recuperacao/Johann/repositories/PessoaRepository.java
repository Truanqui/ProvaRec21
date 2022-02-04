package com.Recuperacao.Johann.repositories;

import com.Recuperacao.Johann.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PessoaRepository extends JpaRepository<Pessoa,Long>{
}
