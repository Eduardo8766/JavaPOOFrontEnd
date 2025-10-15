package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Preco;
import br.com.pdvfrontend.service.PrecoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PrecoList extends JFrame {
    private final PrecoService precoService;
    private final JTable tabela;
    private final DefaultTableModel modelo;

    public PrecoList(PrecoService precoService) {
        super("Gerenciamento de Preços");
        this.precoService = precoService;

        modelo = new DefaultTableModel(new Object[]{"ID do Produto", "Valor de Venda", "Data de Vigência"}, 0);
        tabela = new JTable(modelo);

        JButton adicionarBtn = new JButton("Adicionar");
        JButton removerBtn = new JButton("Remover");
        JButton atualizarBtn = new JButton("Atualizar");

        adicionarBtn.addActionListener(e -> {
            Preco preco = PrecoForm.exibirFormulario();
            if (preco != null) {
                precoService.addPreco(preco);
                atualizarTabela();
            }
        });

        removerBtn.addActionListener(e -> {
            int selecionado = tabela.getSelectedRow();
            if (selecionado >= 0) {
                String produtoId = (String) modelo.getValueAt(selecionado, 0);
                precoService.deletePreco(produtoId);
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
        List<Preco> precos = precoService.getAllPrecos();
        for (Preco p : precos) {
            modelo.addRow(new Object[]{
                    p.getProdutoId(),
                    p.getValorVenda(),
                    p.getDataVigencia()
            });
        }
    }
}

