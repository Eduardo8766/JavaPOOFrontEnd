package br.com.pdvfrontend.service;

import br.com.pdvfrontend.model.Estoque;
import br.com.pdvfrontend.util.CustomHttpClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EstoqueService {
    private static final String BASE_URL = "http://localhost:8080/estoques"; // Ajuste a URL da sua API
    private Gson gson = new Gson();

    public List<Estoque> getAllEstoques() {
        try {
            String json = CustomHttpClient.get(BASE_URL);
            Type listType = new TypeToken<ArrayList<Estoque>>(){}.getType();
            return gson.fromJson(json, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Estoque getEstoqueById(String id) {
        try {
            String json = CustomHttpClient.get(BASE_URL + "/" + id);
            return gson.fromJson(json, Estoque.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addEstoque(Estoque estoque) {
        try {
            String json = gson.toJson(estoque);
            CustomHttpClient.post(BASE_URL, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEstoque(String id, Estoque estoque) {
        try {
            String json = gson.toJson(estoque);
            CustomHttpClient.put(BASE_URL + "/" + id, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEstoque(String id) {
        try {
            CustomHttpClient.delete(BASE_URL + "/" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

