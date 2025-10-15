package br.com.pdvfrontend.view;

import br.com.pdvfrontend.service.*;

import javax.swing.*;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gerenciamento PDV");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 500);
            frame.setLayout(new GridLayout(7, 1, 10, 10)); // 7 botões, 1 coluna
            frame.setLocationRelativeTo(null);

            // Botão Gerenciar Pessoas
            JButton btnPessoas = new JButton("Gerenciar Pessoas");
            btnPessoas.addActionListener(e -> {
                PessoaService pessoaService = new PessoaService();
                new PessoaList(pessoaService);
            });
            frame.add(btnPessoas);

            // Botão Gerenciar Preços
            JButton btnPrecos = new JButton("Gerenciar Preços");
            btnPrecos.addActionListener(e -> {
                PrecoService precoService = new PrecoService();
                new PrecoList(precoService);
            });
            frame.add(btnPrecos);

            // Botão Gerenciar Produtos
            JButton btnProdutos = new JButton("Gerenciar Produtos");
            btnProdutos.addActionListener(e -> {
                ProdutoService produtoService = new ProdutoService();
                new ProdutoList(produtoService);
            });
            frame.add(btnProdutos);

            // Botão Gerenciar Custos
            JButton btnCustos = new JButton("Gerenciar Custos");
            btnCustos.addActionListener(e -> {
                CustoService custoService = new CustoService();
                new CustoList(custoService);
            });
            frame.add(btnCustos);

            // Botão Gerenciar Estoques
            JButton btnEstoques = new JButton("Gerenciar Estoques");
            btnEstoques.addActionListener(e -> {
                EstoqueService estoqueService = new EstoqueService();
                new EstoqueList(estoqueService);
            });
            frame.add(btnEstoques);

            // Botão Gerenciar Acessos
            JButton btnAcessos = new JButton("Gerenciar Acessos");
            btnAcessos.addActionListener(e -> {
                AcessoService acessoService = new AcessoService();
                new AcessoList(acessoService);
            });
            frame.add(btnAcessos);

            // Botão Gerenciar Contatos
            JButton btnContatos = new JButton("Gerenciar Contatos");
            btnContatos.addActionListener(e -> {
                ContatoService contatoService = new ContatoService();
                new ContatoList(contatoService);
            });
            frame.add(btnContatos);

            frame.setVisible(true);
        });
    }
}

