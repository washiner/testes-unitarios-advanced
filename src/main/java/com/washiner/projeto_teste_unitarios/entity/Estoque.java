package com.washiner.projeto_teste_unitarios.entity;

import java.util.List;

public class Estoque {

    public List<String> listarProdutos(){
        return List.of("Notebook", "Mouse", "Teclado");
    }
}