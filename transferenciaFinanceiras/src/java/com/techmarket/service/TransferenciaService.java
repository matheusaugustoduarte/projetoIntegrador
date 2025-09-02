/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techmarket.service;

/**
 *
 * @author Math
 */
import com.techmarket.model.Transferencia;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransferenciaService {

    private List<Transferencia> historico = new ArrayList<>();
    private double saldoContaOrigem = 5000.00; // saldo fictício

    public Transferencia realizarTransferencia(String origem, String destino, double valor) {
        if (valor <= 0) {
            return new Transferencia(origem, destino, valor, "Erro", "Valor inválido para transferência.");
        }

        if (valor > saldoContaOrigem) {
            return new Transferencia(origem, destino, valor, "Erro", "Saldo insuficiente.");
        }

        saldoContaOrigem -= valor;

        Transferencia t = new Transferencia(origem, destino, valor, "Sucesso", "Transferência realizada com sucesso.");
        historico.add(t);
        return t;
    }

    public List<Transferencia> listarTransacoes() {
        return historico;
    }
}