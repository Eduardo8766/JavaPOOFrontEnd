package br.com.pdvfrontend.model;

import java.time.LocalDate;

public class Preco {
    private String produtoId;
    private double valorVenda;
    private LocalDate dataVigencia;

    public Preco(String produtoId, double valorVenda, LocalDate dataVigencia) {
        this.produtoId = produtoId;
        this.valorVenda = valorVenda;
        this.dataVigencia = dataVigencia;
    }

    // Getters e Setters
    public String getProdutoId() { return produtoId; }
    public void setProdutoId(String produtoId) { this.produtoId = produtoId; }

    public double getValorVenda() { return valorVenda; }
    public void setValorVenda(double valorVenda) { this.valorVenda = valorVenda; }

    public LocalDate getDataVigencia() { return dataVigencia; }
    public void setDataVigencia(LocalDate dataVigencia) { this.dataVigencia = dataVigencia; }
}

