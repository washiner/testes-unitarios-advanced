package com.washiner.projeto_teste_unitarios;

import com.washiner.projeto_teste_unitarios.entity.Produto;
import com.washiner.projeto_teste_unitarios.repository.ProdutoRepository;
import com.washiner.projeto_teste_unitarios.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)    // avisa o JUnit que vai usar o Mockito
public class ProdutoServiceTestes {

    // CRIA O DUBLÊ do repository
    @Mock
    ProdutoRepository repository;

    // INJETA o dublê dentro do service automaticamente
    @InjectMocks
    ProdutoService service;

    @Test
    void deveBuscarNomeDoProduto(){

        // ARRANGE — fala pro dublê o que retornar
        Produto produto = new Produto("Notebook");
        when(repository.findById(1L)).thenReturn(produto);

        // ACT — chama o service de verdade
        String resultado = service.buscarNome(1L);

        // ASSERT — verifica o resultado

        assertThat(resultado).isEqualTo("Notebook");

    }


}











