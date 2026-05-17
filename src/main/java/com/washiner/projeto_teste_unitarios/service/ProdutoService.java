package com.washiner.projeto_teste_unitarios.service;

import com.washiner.projeto_teste_unitarios.entity.Produto;
import com.washiner.projeto_teste_unitarios.repository.ProdutoRepository;

public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public String buscarNome(Long id) {
        Produto produto = repository.findById(id);
        return produto.getNome();
    }

    public void salvar(Produto produto) {
        repository.save(produto);
    }
}