package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Acesso;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AcessoForm {
    public static Acesso exibirFormulario() {
        JTextField usuarioField = new JTextField();
        JPasswordField senhaField = new JPasswordField();
        JTextField ultimoAcessoField = new JTextField(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        Object[] fields = {
                "Usuário:", usuarioField,
                "Senha:", senhaField,
                "Último Acesso (yyyy-MM-ddTHH:mm:ss):", ultimoAcessoField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Novo Acesso", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String usuario = usuarioField.getText();
            String senha = new String(senhaField.getPassword());
            LocalDateTime ultimoAcesso = LocalDateTime.parse(ultimoAcessoField.getText(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            return new Acesso(usuario, senha, ultimoAcesso);
        }
        return null;
    }
}

