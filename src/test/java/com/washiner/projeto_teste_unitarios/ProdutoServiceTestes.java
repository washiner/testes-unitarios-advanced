package com.washiner.projeto_teste_unitarios;

import com.washiner.projeto_teste_unitarios.entity.Produto;
import com.washiner.projeto_teste_unitarios.repository.ProdutoRepository;
import com.washiner.projeto_teste_unitarios.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
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

    @Test
    void deveSalvarProduto(){

        //arrange

        Produto produto = new Produto("Notebook");

        //act

        service.salvar(produto);

        // ASSERT — verifica se o save foi chamado com esse produto

        verify(repository).save(produto);
    }

    @Test
    void deveRetornarMensagemQuandoRepositoryLancarErro(){

        // ARRANGE — manda o dublê lançar exceção
        when(repository.findById(1L))
                .thenThrow(new RuntimeException("Banco fora do ar"));

        //ACT

        String resultado = service.buscarNomeComTratamento(1L);

        //assert

        assertThat(resultado).isEqualTo("Produto não encontrado");
    }

    @Test
    void deveAplicarDescontoAoSalvar() {

        // ARRANGE — cria o captor do tipo Produto
        ArgumentCaptor<Produto> captor = ArgumentCaptor.forClass(Produto.class);

        // ACT
        service.salvarComDesconto("Notebook", 1000.0);

        // ASSERT — captura o objeto que foi passado pro save
        verify(repository).save(captor.capture());

        // inspeciona o objeto capturado
        Produto produtoSalvo = captor.getValue();
        assertThat(produtoSalvo.getNome()).isEqualTo("Notebook");
        assertThat(produtoSalvo.getPreco()).isEqualTo(900.0);
    }
}











