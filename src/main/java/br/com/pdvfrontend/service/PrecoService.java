package br.com.pdvfrontend.service;

import br.com.pdvfrontend.model.Preco;
import br.com.pdvfrontend.util.CustomHttpClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrecoService {
    private static final String BASE_URL = "http://localhost:8080/precos"; // Ajuste a URL da sua API
    private Gson gson = new Gson();

    public List<Preco> getAllPrecos() {
        try {
            String json = CustomHttpClient.get(BASE_URL);
            Type listType = new TypeToken<ArrayList<Preco>>(){}.getType();
            return gson.fromJson(json, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Preco getPrecoById(String id) {
        try {
            String json = CustomHttpClient.get(BASE_URL + "/" + id);
            return gson.fromJson(json, Preco.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addPreco(Preco preco) {
        try {
            String json = gson.toJson(preco);
            CustomHttpClient.post(BASE_URL, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePreco(String id, Preco preco) {
        try {
            String json = gson.toJson(preco);
            CustomHttpClient.put(BASE_URL + "/" + id, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePreco(String id) {
        try {
            CustomHttpClient.delete(BASE_URL + "/" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

