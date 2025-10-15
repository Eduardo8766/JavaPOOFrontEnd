package br.com.pdvfrontend.model;

public class Produto {
    private String nome;
    private String descricao;
    private String codigoBarra;

    public Produto(String nome, String descricao, String codigoBarra) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigoBarra = codigoBarra;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCodigoBarra() { return codigoBarra; }
    public void setCodigoBarra(String codigoBarra) { this.codigoBarra = codigoBarra; }
}

