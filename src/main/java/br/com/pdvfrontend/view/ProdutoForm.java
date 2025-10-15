package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Produto;

import javax.swing.*;

public class ProdutoForm {
    public static Produto exibirFormulario() {
        JTextField nomeField = new JTextField();
        JTextField descricaoField = new JTextField();
        JTextField codigoBarraField = new JTextField();

        Object[] fields = {
                "Nome:", nomeField,
                "Descrição:", descricaoField,
                "Código de Barras:", codigoBarraField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Novo Produto", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            String descricao = descricaoField.getText();
            String codigoBarra = codigoBarraField.getText();

            return new Produto(nome, descricao, codigoBarra);
        }
        return null;
    }
}

