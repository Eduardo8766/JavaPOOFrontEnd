package br.com.pdvfrontend.model;

public enum TipoPessoa {
    FISICA("Física"),
    JURIDICA("Jurídica");

    private final String label;

    TipoPessoa(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
