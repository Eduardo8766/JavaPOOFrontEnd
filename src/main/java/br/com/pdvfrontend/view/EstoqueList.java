package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Estoque;
import br.com.pdvfrontend.service.EstoqueService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EstoqueList extends JFrame {
    private final EstoqueService estoqueService;
    private final JTable tabela;
    private final DefaultTableModel modelo;

    public EstoqueList(EstoqueService estoqueService) {
        super("Gerenciamento de Estoques");
        this.estoqueService = estoqueService;

        modelo = new DefaultTableModel(new Object[]{"ID do Produto", "Quantidade", "Última Atualização"}, 0);
        tabela = new JTable(modelo);

        JButton adicionarBtn = new JButton("Adicionar");
        JButton removerBtn = new JButton("Remover");
        JButton atualizarBtn = new JButton("Atualizar");

        adicionarBtn.addActionListener(e -> {
            Estoque estoque = EstoqueForm.exibirFormulario();
            if (estoque != null) {
                estoqueService.addEstoque(estoque);
                atualizarTabela();
            }
        });

        removerBtn.addActionListener(e -> {
            int selecionado = tabela.getSelectedRow();
            if (selecionado >= 0) {
                String produtoId = (String) modelo.getValueAt(selecionado, 0);
                estoqueService.deleteEstoque(produtoId);
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
        List<Estoque> estoques = estoqueService.getAllEstoques();
        for (Estoque e : estoques) {
            modelo.addRow(new Object[]{
                    e.getProdutoId(),
                    e.getQuantidade(),
                    e.getUltimaAtualizacao()
            });
        }
    }
}

