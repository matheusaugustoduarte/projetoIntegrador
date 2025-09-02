/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techmarket.controller;

/**
 *
 * @author Math
 */

import com.techmarket.model.Transferencia;
import com.techmarket.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService service;

    // POST: realiza uma transferência
    @PostMapping
    public Transferencia transferir(@RequestBody TransferenciaRequest request) {
        return service.realizarTransferencia(
                request.getContaOrigem(),
                request.getContaDestino(),
                request.getValor()
        );
    }

    // GET: lista o histórico
    @GetMapping
    public List<Transferencia> listar() {
        return service.listarTransacoes();
    }
}

// DTO para receber JSON
class TransferenciaRequest {
    private String contaOrigem;
    private String contaDestino;
    private double valor;

    public String getContaOrigem() { return contaOrigem; }
    public void setContaOrigem(String contaOrigem) { this.contaOrigem = contaOrigem; }
    public String getContaDestino() { return contaDestino; }
    public void setContaDestino(String contaDestino) { this.contaDestino = contaDestino; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
}
