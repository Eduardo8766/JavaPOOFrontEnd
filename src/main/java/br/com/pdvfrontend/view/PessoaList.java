package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Pessoa;
import br.com.pdvfrontend.service.PessoaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PessoaList extends JFrame {
    private final PessoaService pessoaService;
    private final JTable tabela;
    private final DefaultTableModel modelo;

    public PessoaList(PessoaService pessoaService) {
        super("Gerenciamento de Pessoas");
        this.pessoaService = pessoaService;

        modelo = new DefaultTableModel(new Object[]{"Nome", "CTPS", "Data de Nascimento", "Tipo"}, 0);
        tabela = new JTable(modelo);

        JButton adicionarBtn = new JButton("Adicionar");
        JButton removerBtn = new JButton("Remover");
        JButton atualizarBtn = new JButton("Atualizar");

        adicionarBtn.addActionListener(e -> {
            Pessoa pessoa = PessoaForm.exibirFormulario();
            if (pessoa != null) {
                pessoaService.adicionar(pessoa);
                atualizarTabela();
            }
        });

        removerBtn.addActionListener(e -> {
            int selecionado = tabela.getSelectedRow();
            if (selecionado >= 0) {
                pessoaService.remover(pessoaService.listar().get(selecionado));
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

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarTabela() {
        modelo.setRowCount(0);
        List<Pessoa> pessoas = pessoaService.listar();
        for (Pessoa p : pessoas) {
            modelo.addRow(new Object[]{
                    p.getNome(),
                    p.getCtps(),
                    p.getDataNascimento(),
                    p.getTipo()
            });
        }
    }
}
