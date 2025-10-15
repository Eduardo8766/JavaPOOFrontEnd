package br.com.pdvfrontend.service;

import br.com.pdvfrontend.model.Acesso;
import br.com.pdvfrontend.util.CustomHttpClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AcessoService {
    private static final String BASE_URL = "http://localhost:8080/acessos"; // Ajuste a URL da sua API
    private Gson gson = new Gson();

    public List<Acesso> getAllAcessos() {
        try {
            String json = CustomHttpClient.get(BASE_URL);
            Type listType = new TypeToken<ArrayList<Acesso>>(){}.getType();
            return gson.fromJson(json, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Acesso getAcessoById(String id) {
        try {
            String json = CustomHttpClient.get(BASE_URL + "/" + id);
            return gson.fromJson(json, Acesso.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addAcesso(Acesso acesso) {
        try {
            String json = gson.toJson(acesso);
            CustomHttpClient.post(BASE_URL, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAcesso(String id, Acesso acesso) {
        try {
            String json = gson.toJson(acesso);
            CustomHttpClient.put(BASE_URL + "/" + id, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAcesso(String id) {
        try {
            CustomHttpClient.delete(BASE_URL + "/" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

