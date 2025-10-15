package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Pessoa;
import br.com.pdvfrontend.model.TipoPessoa;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PessoaForm {
    public static Pessoa exibirFormulario() {
        JTextField nomeField = new JTextField();
        JTextField ctpsField = new JTextField();
        JTextField dataNascimentoField = new JTextField();
        JComboBox<TipoPessoa> tipoBox = new JComboBox<>(TipoPessoa.values());

        Object[] fields = {
                "Nome:", nomeField,
                "CTPS:", ctpsField,
                "Data de Nascimento (yyyy-MM-dd):", dataNascimentoField,
                "Tipo:", tipoBox
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Nova Pessoa", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            String ctps = ctpsField.getText();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
            TipoPessoa tipo = (TipoPessoa) tipoBox.getSelectedItem();

            return new Pessoa(nome, ctps, dataNascimento, tipo);
        }
        return null;
    }
}
