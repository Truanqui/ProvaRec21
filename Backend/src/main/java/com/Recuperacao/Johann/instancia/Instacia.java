package com.Recuperacao.Johann.instancia;

import com.Recuperacao.Johann.models.*;
import com.Recuperacao.Johann.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;


@Configuration
public class Instacia implements CommandLineRunner{
    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    EditoraRepository editoraRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    ExemplarRepository exemplarRepository;

    @Override
    public void run (String... args) throws Exception {

        Pessoa pessoa1 = new Pessoa(null, "Johann Teixeira Maciel", "22475121818", "232478903", "johannteixeira@gmail.com", "999888777", "EnderecoResidencial", "EnderecoComercial", true);
        Pessoa pessoa2 = new Pessoa(null, "Cinthya Teixeira Morrisson", "23315869629", "82713794", "cinthyateixeira@gmail.com", "888666555", "EnderecoResidencial", "EnderecoComercial", true);
        pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2));

        Autor autor1 = new Autor(null, "J. K. Rowling");
        Autor autor2 = new Autor(null, "J. R. R. Tolkien");
        autorRepository.saveAll(Arrays.asList(autor1, autor2));

        Editora editora1 = new Editora(null, "Rocco");
        Editora editora2 = new Editora(null, "Martins Fontes");
        editoraRepository.saveAll(Arrays.asList(editora1, editora2));

        Categoria categoria1 = new Categoria(null, "Mistico", 3);
        Categoria categoria2 = new Categoria(null, "Aventura", 5);
        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));

        Livro livro1 = new Livro(null, "A sociedade do Anel", categoria2,editora1,autor1);
        Livro livro2 = new Livro(null, "As duas torres", categoria2,editora1, autor1);
        Livro livro3 = new Livro(null, "O Retorno do Rei",categoria1,editora1,autor1);
        Livro livro4 = new Livro(null, "A pedra filosofal", categoria1, editora2, autor2);
        Livro livro5 = new Livro(null, "A camara secreta", categoria2,editora2, autor2);
        livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5));

        Exemplar exemplar1 = new Exemplar(null, livro1);
        exemplarRepository.saveAll(Arrays.asList(exemplar1));

        Emprestimo emprestimo1 = new Emprestimo(null, LocalDate.now(), LocalDate.now().plusDays(livro1.getCategoria().getDiasCategoria()),true, pessoa2, exemplar1);
        emprestimoRepository.saveAll(Arrays.asList(emprestimo1));
    }
}
