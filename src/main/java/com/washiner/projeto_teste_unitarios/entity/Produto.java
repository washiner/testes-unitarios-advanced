package com.washiner.projeto_teste_unitarios.entity;

public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}
