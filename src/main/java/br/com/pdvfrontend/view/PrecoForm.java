package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Preco;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrecoForm {
    public static Preco exibirFormulario() {
        JTextField produtoIdField = new JTextField();
        JTextField valorVendaField = new JTextField();
        JTextField dataVigenciaField = new JTextField(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));

        Object[] fields = {
                "ID do Produto:", produtoIdField,
                "Valor de Venda:", valorVendaField,
                "Data de Vigência (yyyy-MM-dd):", dataVigenciaField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Novo Preço", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String produtoId = produtoIdField.getText();
            double valorVenda = Double.parseDouble(valorVendaField.getText());
            LocalDate dataVigencia = LocalDate.parse(dataVigenciaField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);

            return new Preco(produtoId, valorVenda, dataVigencia);
        }
        return null;
    }
}

