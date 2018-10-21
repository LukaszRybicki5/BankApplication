package com.jsonparser;

import com.model.Client;
import com.sun.javafx.iio.ios.IosDescriptor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class JSONFileToArrayMaker {

    private static final String FILENAME = "bankData.json";

    public List<Client> putingJSONFileToArray() {

        if ((putDataToPersonList(readJsonData(FILENAME))) == null) {
            System.out.println("Program zostanie zamknięty!!!");
            exit(0);
        }
        return putDataToPersonList(readJsonData(FILENAME));

    }

    private JSONArray readJsonData(String inputFile) {
        JSONParser parser = new JSONParser();
        JSONArray array = null;

        try {
            File file = new File(inputFile);
            FileInputStream fileInputStream = new FileInputStream(file);

            BufferedReader in = new BufferedReader(new InputStreamReader(fileInputStream));

            array = (JSONArray) parser.parse(in);

            fileInputStream.close();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    private List<Client> putDataToPersonList(JSONArray array) {

        try {
            List<Client> clientList = new ArrayList<>();

            for (Object obj : array) {
                JSONObject json = (JSONObject) obj;

                clientList.add(
                        new Client(
                                (String) json.get("firstName"),
                                (String) json.get("lastName"),
                                (Long) json.get("accountNumber"),
                                (Double) json.get("accountBalance"),
                                (String) json.get("accountLogin"),
                                (String) json.get("accountPassword"),
                                (String) json.get("city"),
                                (String) json.get("street"),
                                (String) json.get("numberOfHouse"),
                                (String) json.get("postalCode"),
                                (Double) json.get("investmentBalance"),
                                (String) json.get("timeOfOpeningInvestment"),
                                (Double) json.get("investmentProcent")));
            }
            return clientList;
        } catch (ClassCastException e) {
            System.out.println("Wystąpił błąd odczytu pliku!!!");
        }
        return null;

    }
}