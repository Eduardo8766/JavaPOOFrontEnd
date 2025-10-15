package br.com.pdvfrontend.model;

public class Contato {
    private String tipo;
    private String valor;

    public Contato(String tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    // Getters e Setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }
}

