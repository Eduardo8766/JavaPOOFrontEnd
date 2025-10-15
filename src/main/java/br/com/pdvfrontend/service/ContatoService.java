package br.com.pdvfrontend.service;

import br.com.pdvfrontend.model.Contato;
import br.com.pdvfrontend.util.CustomHttpClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ContatoService {
    private static final String BASE_URL = "http://localhost:8080/contatos"; // Ajuste a URL da sua API
    private Gson gson = new Gson();

    public List<Contato> getAllContatos() {
        try {
            String json = CustomHttpClient.get(BASE_URL);
            Type listType = new TypeToken<ArrayList<Contato>>(){}.getType();
            return gson.fromJson(json, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Contato getContatoById(String id) {
        try {
            String json = CustomHttpClient.get(BASE_URL + "/" + id);
            return gson.fromJson(json, Contato.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addContato(Contato contato) {
        try {
            String json = gson.toJson(contato);
            CustomHttpClient.post(BASE_URL, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateContato(String id, Contato contato) {
        try {
            String json = gson.toJson(contato);
            CustomHttpClient.put(BASE_URL + "/" + id, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteContato(String id) {
        try {
            CustomHttpClient.delete(BASE_URL + "/" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

