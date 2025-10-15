package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Acesso;
import br.com.pdvfrontend.service.AcessoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AcessoList extends JFrame {
    private final AcessoService acessoService;
    private final JTable tabela;
    private final DefaultTableModel modelo;

    public AcessoList(AcessoService acessoService) {
        super("Gerenciamento de Acessos");
        this.acessoService = acessoService;

        modelo = new DefaultTableModel(new Object[]{"Usuário", "Último Acesso"}, 0);
        tabela = new JTable(modelo);

        JButton adicionarBtn = new JButton("Adicionar");
        JButton removerBtn = new JButton("Remover");
        JButton atualizarBtn = new JButton("Atualizar");

        adicionarBtn.addActionListener(e -> {
            Acesso acesso = AcessoForm.exibirFormulario();
            if (acesso != null) {
                acessoService.addAcesso(acesso);
                atualizarTabela();
            }
        });

        removerBtn.addActionListener(e -> {
            int selecionado = tabela.getSelectedRow();
            if (selecionado >= 0) {
                // Necessário um ID para remover, assumindo que o usuário é o ID para simplificar
                String usuario = (String) modelo.getValueAt(selecionado, 0);
                acessoService.deleteAcesso(usuario);
                atualizarTabela();
            }
        });

        atualizarBtn.addActionListener(e -> atualizarTabela());

        JPanel botoes = new JPanel();
        botoes.add(adicionarBtn);
        botoes.add(removerBtn);
        botoes.add(atualizarBtn);

        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        atualizarTabela();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarTabela() {
        modelo.setRowCount(0);
        List<Acesso> acessos = acessoService.getAllAcessos();
        for (Acesso a : acessos) {
            modelo.addRow(new Object[]{
                    a.getUsuario(),
                    a.getUltimoAcesso()
            });
        }
    }
}

