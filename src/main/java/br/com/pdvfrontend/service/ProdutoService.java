package br.com.pdvfrontend.service;

import br.com.pdvfrontend.model.Produto;
import br.com.pdvfrontend.util.CustomHttpClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private static final String BASE_URL = "http://localhost:8080/produtos"; // Ajuste a URL da sua API
    private Gson gson = new Gson();

    public List<Produto> getAllProdutos() {
        try {
            String json = CustomHttpClient.get(BASE_URL);
            Type listType = new TypeToken<ArrayList<Produto>>(){}.getType();
            return gson.fromJson(json, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Produto getProdutoById(String id) {
        try {
            String json = CustomHttpClient.get(BASE_URL + "/" + id);
            return gson.fromJson(json, Produto.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addProduto(Produto produto) {
        try {
            String json = gson.toJson(produto);
            CustomHttpClient.post(BASE_URL, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduto(String id, Produto produto) {
        try {
            String json = gson.toJson(produto);
            CustomHttpClient.put(BASE_URL + "/" + id, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduto(String id) {
        try {
            CustomHttpClient.delete(BASE_URL + "/" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

