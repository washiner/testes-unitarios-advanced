package com.washiner.projeto_teste_unitarios.entity;

public class Calculadora {

    public int somarNumeros(int a, int b) {
        return a + b;
    }

    public int subtrairNumeros( int a, int b){
        return a - b;
    }

    public int multiplicarNumeros( int a, int b){
        return a * b;
    }

    public int dividirNumeros(int a, int b){
        if (b == 0){
            throw new IllegalArgumentException("Não pode ser dividido por zero");
        }
        return a / b;
    }

    public boolean ehPositivo(int numero){
        return numero > 0;
    }
}
