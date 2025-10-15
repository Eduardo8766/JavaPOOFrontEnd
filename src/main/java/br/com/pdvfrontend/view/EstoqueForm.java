package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Estoque;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EstoqueForm {
    public static Estoque exibirFormulario() {
        JTextField produtoIdField = new JTextField();
        JTextField quantidadeField = new JTextField();
        JTextField ultimaAtualizacaoField = new JTextField(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        Object[] fields = {
                "ID do Produto:", produtoIdField,
                "Quantidade:", quantidadeField,
                "Última Atualização (yyyy-MM-ddTHH:mm:ss):", ultimaAtualizacaoField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Novo Estoque", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String produtoId = produtoIdField.getText();
            int quantidade = Integer.parseInt(quantidadeField.getText());
            LocalDateTime ultimaAtualizacao = LocalDateTime.parse(ultimaAtualizacaoField.getText(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            return new Estoque(produtoId, quantidade, ultimaAtualizacao);
        }
        return null;
    }
}

