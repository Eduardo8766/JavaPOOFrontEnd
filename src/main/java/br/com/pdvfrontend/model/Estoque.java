package br.com.pdvfrontend.model;

import java.time.LocalDateTime;

public class Estoque {
    private String produtoId;
    private int quantidade;
    private LocalDateTime ultimaAtualizacao;

    public Estoque(String produtoId, int quantidade, LocalDateTime ultimaAtualizacao) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    // Getters e Setters
    public String getProdutoId() { return produtoId; }
    public void setProdutoId(String produtoId) { this.produtoId = produtoId; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public LocalDateTime getUltimaAtualizacao() { return ultimaAtualizacao; }
    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) { this.ultimaAtualizacao = ultimaAtualizacao; }
}

