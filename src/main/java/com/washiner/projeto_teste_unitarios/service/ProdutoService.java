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

    public String buscarNomeComTratamento(Long id){
        try {
            Produto produto = repository.findById(id);
            return produto.getNome();
        }catch (RuntimeException exception){
            return "Produto não encontrado";
        }
    }

    public void salvarComDesconto(String nome, double preco) {
        Produto produto = new Produto(nome);
        produto.setPreco(preco * 0.9); // aplica 10% de desconto
        repository.save(produto);
    }
}