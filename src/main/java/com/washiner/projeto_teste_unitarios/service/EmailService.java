package com.washiner.projeto_teste_unitarios.service;

public class EmailService {

    public String formatarEmail(String email) {
        return email.toLowerCase().trim();
    }

    public void enviarEmail(String email) {
        // imagina que aqui conecta num servidor de email
        System.out.println("Enviando email para: " + email);
    }
}
