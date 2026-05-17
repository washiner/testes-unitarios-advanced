package com.washiner.projeto_teste_unitarios.entity;

import java.util.List;

public class Estoque {

    public List<String> listarProdutos() {
        return List.of("Notebook", "Mouse", "Teclado");
    }

    // retorna lista vazia
    public List<String> listarProdutosVazio() {
        return List.of();
    }

    // busca produto por nome, retorna null se nao achar
    public String buscarProduto(String nome) {
        List<String> produtos = List.of("Notebook", "Mouse", "Teclado");
        return produtos.stream()
                .filter(p -> p.equals(nome))
                .findFirst()
                .orElse(null);
    }
}
