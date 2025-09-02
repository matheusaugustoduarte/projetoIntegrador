/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.Transferencia to edit this template
 */
package com.techmarket.model;

/**
 *
 * @author Math
 */

import java.time.LocalDateTime;
import java.util.UUID;

public class Transferencia {
    private String codigoOperacao;
    private String contaOrigem;
    private String contaDestino;
    private double valor;
    private LocalDateTime dataHora;
    private String status;
    private String mensagem;

    public Transferencia(String contaOrigem, String contaDestino, double valor, String status, String mensagem) {
        this.codigoOperacao = UUID.randomUUID().toString();
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.status = status;
        this.mensagem = mensagem;
    }

    public String getCodigoOperacao() { return codigoOperacao; }
    public String getContaOrigem() { return contaOrigem; }
    public String getContaDestino() { return contaDestino; }
    public double getValor() { return valor; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getStatus() { return status; }
    public String getMensagem() { return mensagem; }
}
