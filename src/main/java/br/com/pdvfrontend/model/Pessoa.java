package br.com.pdvfrontend.model;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private String ctps;
    private LocalDate dataNascimento;
    private TipoPessoa tipo;

    public Pessoa(String nome, String ctps, LocalDate dataNascimento, TipoPessoa tipo) {
        this.nome = nome;
        this.ctps = ctps;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCtps() { return ctps; }
    public void setCtps(String ctps) { this.ctps = ctps; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public TipoPessoa getTipo() { return tipo; }
    public void setTipo(TipoPessoa tipo) { this.tipo = tipo; }
}
