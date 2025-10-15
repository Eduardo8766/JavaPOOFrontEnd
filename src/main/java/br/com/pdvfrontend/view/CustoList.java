package br.com.pdvfrontend.view;

import br.com.pdvfrontend.model.Custo;
import br.com.pdvfrontend.service.CustoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CustoList extends JFrame {
    private final CustoService custoService;
    private final JTable tabela;
    private final DefaultTableModel modelo;

    public CustoList(CustoService custoService) {
        super("Gerenciamento de Custos");
        this.custoService = custoService;

        modelo = new DefaultTableModel(new Object[]{"Descrição", "Valor", "Data do Custo"}, 0);
        tabela = new JTable(modelo);

        JButton adicionarBtn = new JButton("Adicionar");
        JButton removerBtn = new JButton("Remover");
        JButton atualizarBtn = new JButton("Atualizar");

        adicionarBtn.addActionListener(e -> {
            Custo custo = CustoForm.exibirFormulario();
            if (custo != null) {
                custoService.addCusto(custo);
                atualizarTabela();
            }
        });

        removerBtn.addActionListener(e -> {
            int selecionado = tabela.getSelectedRow();
            if (selecionado >= 0) {
                // Necessário um ID para remover, assumindo que a descrição é o ID para simplificar
                String descricao = (String) modelo.getValueAt(selecionado, 0);
                custoService.deleteCusto(descricao);
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
        List<Custo> custos = custoService.getAllCustos();
        for (Custo c : custos) {
            modelo.addRow(new Object[]{
                    c.getDescricao(),
                    c.getValor(),
                    c.getDataCusto()
            });
        }
    }
}

