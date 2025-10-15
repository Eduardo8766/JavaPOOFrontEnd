package br.com.pdvfrontend.service;

import br.com.pdvfrontend.model.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    private final List<Pessoa> pessoas = new ArrayList<>();

    public List<Pessoa> listar() {
        return pessoas;
    }

    public void adicionar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }
}
