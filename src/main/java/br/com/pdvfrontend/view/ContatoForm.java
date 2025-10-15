package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Contato;

import javax.swing.*;

public class ContatoForm {
    public static Contato exibirFormulario() {
        JTextField tipoField = new JTextField();
        JTextField valorField = new JTextField();

        Object[] fields = {
                "Tipo:", tipoField,
                "Valor:", valorField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Novo Contato", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String tipo = tipoField.getText();
            String valor = valorField.getText();

            return new Contato(tipo, valor);
        }
        return null;
    }
}

