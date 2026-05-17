package com.washiner.projeto_teste_unitarios;

import com.washiner.projeto_teste_unitarios.entity.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculadoraTestes {

    //declara o objeto fora dos testes

    Calculadora calculadora;

    @BeforeEach
    void setup(){
        calculadora = new Calculadora();
    }

    // anoto com @Test para o JUnit saber que e um teste
    @Test
    void deveSomarDoisNumeros() {

        // CRIA O OBJETO — nao precisa mais, já existe
        // CHAMA O MÉTODO
        int resultado = calculadora.somarNumeros(2, 3);

        // VERIFICA O RESULTADO
        assertThat(resultado).isEqualTo(5);
    }

    @Test
    void deveSubtrair(){


        // CRIA O OBJETO — nao precisa mais, já existe
        // CHAMA O MÉTODO
        int resultado = calculadora.subtrairNumeros(20, 10);

        assertThat(resultado).isEqualTo(10);
    }

    @Test
    void deveMultiplicarNumeros(){

        // CRIA O OBJETO — nao precisa mais, já existe
        // CHAMA O MÉTODO
        int resultado = calculadora.multiplicarNumeros(2, 10);

        assertThat(resultado).isEqualTo(20);

    }

    @Test
    void deveDividirNumeros(){

        // CRIA O OBJETO — nao precisa mais, já existe
        // CHAMA O MÉTODO
        int resultado = calculadora.dividirNumeros(40, 2);

        assertThat(resultado).isEqualTo(20);

    }

    @Test
    void deveLancarExcessaoAoDividirPorZero(){

        // CRIA O OBJETO — nao precisa mais, já existe
        // CHAMA O MÉTODO
        // ACT + ASSERT juntos — o act está dentro do assertThatThrownBy

        assertThatThrownBy(()-> calculadora.dividirNumeros(10, 0))
                .isInstanceOf(IllegalArgumentException.class);


    }

}
