package br.com.pdvfrontend.service;

import br.com.pdvfrontend.model.Custo;
import br.com.pdvfrontend.util.CustomHttpClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CustoService {
    private static final String BASE_URL = "http://localhost:8080/custos"; // Ajuste a URL da sua API
    private Gson gson = new Gson();

    public List<Custo> getAllCustos() {
        try {
            String json = CustomHttpClient.get(BASE_URL);
            Type listType = new TypeToken<ArrayList<Custo>>(){}.getType();
            return gson.fromJson(json, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Custo getCustoById(String id) {
        try {
            String json = CustomHttpClient.get(BASE_URL + "/" + id);
            return gson.fromJson(json, Custo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addCusto(Custo custo) {
        try {
            String json = gson.toJson(custo);
            CustomHttpClient.post(BASE_URL, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCusto(String id, Custo custo) {
        try {
            String json = gson.toJson(custo);
            CustomHttpClient.put(BASE_URL + "/" + id, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCusto(String id) {
        try {
            CustomHttpClient.delete(BASE_URL + "/" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

