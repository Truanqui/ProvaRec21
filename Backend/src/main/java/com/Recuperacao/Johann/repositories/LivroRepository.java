package com.Recuperacao.Johann.repositories;

import com.Recuperacao.Johann.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LivroRepository extends JpaRepository<Livro,Long> {
}
