package com.washiner.projeto_teste_unitarios;

import com.washiner.projeto_teste_unitarios.entity.Estoque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProdutoTestes {


    Estoque estoque;

    @BeforeEach
    void setup(){
        estoque = new Estoque();
    }

    @Test
    void deveRetornarTresProdutos(){

        //arrange nao precisa mais

        //chama o metodo
        List<String> resultado = estoque.listarProdutos();

        // mostra o resultado

        assertThat(resultado).hasSize(3);
    }

    @Test
    void deveConterNotebook(){

        List<String> resultado = estoque.listarProdutos();

        assertThat(resultado).contains("Notebook");

    }

    @Test
    void naoDeveEstarVazia(){

        List<String> resultado = estoque.listarProdutos();

        assertThat(resultado).isNotEmpty();
    }

    @Test
    void deveRetornarNullQuandoProdutoNaoExiste() {

        String resultado = estoque.buscarProduto("Cadeira");

        // VERIFICA SE VEIO NULO
        assertThat(resultado).isNull();
    }

    @Test
    void deveAcharProdutoQueExiste() {

        String resultado = estoque.buscarProduto("Mouse");

        // VERIFICA SE NAO E NULO E SE E O CERTO
        assertThat(resultado).isNotNull();
        assertThat(resultado).isEqualTo("Mouse");
    }
}












