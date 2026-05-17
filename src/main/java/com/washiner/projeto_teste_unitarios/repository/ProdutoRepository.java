package com.washiner.projeto_teste_unitarios.repository;

import com.washiner.projeto_teste_unitarios.entity.Produto;

public interface ProdutoRepository {
    Produto findById(Long id);

    void save(Produto produto);
}
