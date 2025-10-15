package br.com.pdvfrontend.model;

import java.time.LocalDate;

public class Custo {
    private String descricao;
    private double valor;
    private LocalDate dataCusto;

    public Custo(String descricao, double valor, LocalDate dataCusto) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataCusto = dataCusto;
    }

    // Getters e Setters
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public LocalDate getDataCusto() { return dataCusto; }
    public void setDataCusto(LocalDate dataCusto) { this.dataCusto = dataCusto; }
}

