package com.Recuperacao.Johann;

import com.Recuperacao.Johann.Criador.*;
import com.Recuperacao.Johann.models.*;
import com.Recuperacao.Johann.repositories.*;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log4j2

public class TesteIntegracao {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ExemplarRepository exemplarRepository;

    @Autowired
    EditoraRepository editoraRepository;

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @BeforeEach
    void setup(){

        autorRepository.save(AutorCriador.autorCriador());
        categoriaRepository.save(CategoriaCriador.categoriaCriador());
        editoraRepository.save(EditoraCriador.editoraCriador());
        emprestimoRepository.save(EmprestimoCriador.emprestimoCriador());
        exemplarRepository.saveAll(ExemplarCriador.exemplarListaCriar());
        exemplarRepository.save(ExemplarCriador.exemplarCriador());
        livroRepository.save(LivroCriador.livroCriador());
        pessoaRepository.save(PessoaCriador.pessoaCriador());

    }
    //Teste Autor
    @Test
    void DeletarAutorRetornaSucesso() {
        Long id = 1L;
        this.testRestTemplate.delete("http://localhost:" + port + "/autor/", id);
    }
    //Teste Categoria
    @Test
    void BuscaCategoriaRetornaSucesso(){
        ResponseEntity<Categoria> resp =
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/categoria/1", Categoria.class);
        Categoria respCat = resp.getBody();
        System.out.print("teste" + respCat);
        Assertions.assertThat(respCat).isNotNull();
    }
    //Teste Editora
    @Test
    void AlterarEdtitoraRetornaSucesso(){
        Optional<Editora> respEditora = editoraRepository.findById(1L);
        Editora editora = new Editora(1L, "editora");
        this.testRestTemplate.put("http://localhost:" + port + "/editora/" + 1L, editora);
        Assertions.assertThat(respEditora.get().getNomeEditora()).isNotEqualTo(editora.getNomeEditora());
    }
    //Teste Emprestimo
    @Test
    void DataDev_MaiorDataEmprestimoRetornarSucesso(){
        ResponseEntity<Emprestimo> resp =
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/emprestimo/1", Emprestimo.class);
        Emprestimo respEmprestimo = resp.getBody();
        System.out.print("teste" + respEmprestimo);
        Assertions.assertThat(respEmprestimo).isNotNull();
        Assertions.assertThat(respEmprestimo.getDataFinal()).isEqualTo(LocalDate.now().plusDays(3));
    }
    //Teste Exemplar
    @Test
    void ReturnExemplarListaRetornarSucesso(){

        ResponseEntity<Exemplar[]> resp =
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/exemplar", Exemplar[].class);
        Exemplar[] exemplar = resp.getBody();

        System.out.print("teste" + exemplar);

        assertAll(() -> assertNotNull(exemplar), () -> assertEquals(4, exemplar.length));
    }
    //Teste Livro
    @Test
    void BuscaLivroRetornaSucesso(){
        ResponseEntity<Livro> resp=
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/livro/1", Livro.class);
        Livro respLivro = resp.getBody();
        System.out.print("teste" + respLivro);
        Assertions.assertThat(respLivro).isNotNull();
    }
    //Teste Pessoa
    @Test
    void CriaPessoaRetornaSucesso(){
        Pessoa usu1 = new Pessoa(null, "nome", "cpf", "rg", "email", "telefone", "enderecoR", "enderecoC", true);
        ResponseEntity<Pessoa> resp =
                this.testRestTemplate.postForEntity("http://localhost:" + port + "/pessoa", usu1, Pessoa.class);
        Assertions.assertThat(resp.getBody()).isNotNull();
        Assertions.assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
