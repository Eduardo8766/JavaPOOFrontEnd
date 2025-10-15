package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Produto;
import br.com.pdvfrontend.service.ProdutoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProdutoList extends JFrame {
    private final ProdutoService produtoService;
    private final JTable tabela;
    private final DefaultTableModel modelo;

    public ProdutoList(ProdutoService produtoService) {
        super("Gerenciamento de Produtos");
        this.produtoService = produtoService;

        modelo = new DefaultTableModel(new Object[]{"Nome", "Descrição", "Código de Barras"}, 0);
        tabela = new JTable(modelo);

        JButton adicionarBtn = new JButton("Adicionar");
        JButton removerBtn = new JButton("Remover");
        JButton atualizarBtn = new JButton("Atualizar");

        adicionarBtn.addActionListener(e -> {
            Produto produto = ProdutoForm.exibirFormulario();
            if (produto != null) {
                produtoService.addProduto(produto);
                atualizarTabela();
            }
        });

        removerBtn.addActionListener(e -> {
            int selecionado = tabela.getSelectedRow();
            if (selecionado >= 0) {
                String nomeProduto = (String) modelo.getValueAt(selecionado, 0);
                produtoService.deleteProduto(nomeProduto);
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
        List<Produto> produtos = produtoService.getAllProdutos();
        for (Produto p : produtos) {
            modelo.addRow(new Object[]{
                    p.getNome(),
                    p.getDescricao(),
                    p.getCodigoBarra()
            });
        }
    }
}

