package com.washiner.projeto_teste_unitarios;

import com.washiner.projeto_teste_unitarios.entity.Calculadora;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculadoraTestes {

    // anoto com @Test para o JUnit saber que e um teste
    @Test
    void deveSomarDoisNumeros() {

        // CRIA O OBJETO
        Calculadora calculadora = new Calculadora();

        // CHAMA O MÉTODO — agora passa dois parametros
        int resultado = calculadora.somarNumeros(2, 3);

        // VERIFICA O RESULTADO
        assertThat(resultado).isEqualTo(5);
    }

    @Test
    void deveSubtrair(){

        Calculadora calc2 = new Calculadora();

        int resultado = calc2.subtrairNumeros(20, 10);

        assertThat(resultado).isEqualTo(10);
    }

    @Test
    void deveMultiplicarNumeros(){

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.multiplicarNumeros(2, 10);

        assertThat(resultado).isEqualTo(20);

    }

    @Test
    void deveDividirNumeros(){

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.dividirNumeros(40, 2);

        assertThat(resultado).isEqualTo(20);

    }

    @Test
    void deveLancarExcessaoAoDividirPorZero(){

        // ARRANGE - cria o objeto

        Calculadora calculadora = new Calculadora();

        // ACT + ASSERT juntos — o act está dentro do assertThatThrownBy

        assertThatThrownBy(()-> calculadora.dividirNumeros(10, 0))
                .isInstanceOf(IllegalArgumentException.class);


    }

}
