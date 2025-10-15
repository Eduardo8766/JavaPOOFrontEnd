package br.com.pdvfrontend.model;

import java.time.LocalDateTime;

public class Acesso {
    private String usuario;
    private String senha;
    private LocalDateTime ultimoAcesso;

    public Acesso(String usuario, String senha, LocalDateTime ultimoAcesso) {
        this.usuario = usuario;
        this.senha = senha;
        this.ultimoAcesso = ultimoAcesso;
    }

    // Getters e Setters
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public LocalDateTime getUltimoAcesso() { return ultimoAcesso; }
    public void setUltimoAcesso(LocalDateTime ultimoAcesso) { this.ultimoAcesso = ultimoAcesso; }
}

