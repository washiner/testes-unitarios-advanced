package com.washiner.projeto_teste_unitarios;

import com.washiner.projeto_teste_unitarios.service.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTestes {

    // @Spy — usa o objeto real, mas permite interceptar
    @Spy
    EmailService emailService;

    @Test
    void deveFormatarEmailDeVerdade() {

        // ACT — chama o método real, sem interceptar
        String resultado = emailService.formatarEmail("  JOAO@EMAIL.COM  ");

        // ASSERT — retorno real do método
        assertThat(resultado).isEqualTo("joao@email.com");
    }

    @Test
    void deveInterceptarEnvioDeEmail() {

        // intercepta só o enviarEmail pra nao conectar no servidor
        doNothing().when(emailService).enviarEmail("joao@email.com");

        // ACT — formatar é real, enviar é interceptado
        String email = emailService.formatarEmail("  JOAO@EMAIL.COM  ");
        emailService.enviarEmail(email);

        // ASSERT — confirma que o envio foi chamado
        verify(emailService).enviarEmail("joao@email.com");
    }
}
