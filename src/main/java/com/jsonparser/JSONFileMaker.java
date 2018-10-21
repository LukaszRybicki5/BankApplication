package com.jsonparser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.model.Client;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/*
Tworzymy i edytujemy "pretty" plik json
 */
public class JSONFileMaker implements AccountFileMaker {

    private static final String FILENAME = "bankData.json";

    public void createFile(List<Client> clientList) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(FILENAME)) {
            gson.toJson(clientList, writer);
            writer.close();
        } catch (JsonIOException | IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu danych");
        }
    }
}