package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Contato;
import br.com.pdvfrontend.service.ContatoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ContatoList extends JFrame {
    private final ContatoService contatoService;
    private final JTable tabela;
    private final DefaultTableModel modelo;

    public ContatoList(ContatoService contatoService) {
        super("Gerenciamento de Contatos");
        this.contatoService = contatoService;

        modelo = new DefaultTableModel(new Object[]{"Tipo", "Valor"}, 0);
        tabela = new JTable(modelo);

        JButton adicionarBtn = new JButton("Adicionar");
        JButton removerBtn = new JButton("Remover");
        JButton atualizarBtn = new JButton("Atualizar");

        adicionarBtn.addActionListener(e -> {
            Contato contato = ContatoForm.exibirFormulario();
            if (contato != null) {
                contatoService.addContato(contato);
                atualizarTabela();
            }
        });

        removerBtn.addActionListener(e -> {
            int selecionado = tabela.getSelectedRow();
            if (selecionado >= 0) {
                // Necessário um ID para remover, assumindo que o tipo é o ID para simplificar
                String tipo = (String) modelo.getValueAt(selecionado, 0);
                contatoService.deleteContato(tipo);
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
        List<Contato> contatos = contatoService.getAllContatos();
        for (Contato c : contatos) {
            modelo.addRow(new Object[]{
                    c.getTipo(),
                    c.getValor()
            });
        }
    }
}

