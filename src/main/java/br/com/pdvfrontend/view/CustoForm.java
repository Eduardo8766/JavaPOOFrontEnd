package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Custo;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustoForm {
    public static Custo exibirFormulario() {
        JTextField descricaoField = new JTextField();
        JTextField valorField = new JTextField();
        JTextField dataCustoField = new JTextField(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));

        Object[] fields = {
                "Descrição:", descricaoField,
                "Valor:", valorField,
                "Data do Custo (yyyy-MM-dd):", dataCustoField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Novo Custo", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String descricao = descricaoField.getText();
            double valor = Double.parseDouble(valorField.getText());
            LocalDate dataCusto = LocalDate.parse(dataCustoField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);

            return new Custo(descricao, valor, dataCusto);
        }
        return null;
    }
}

